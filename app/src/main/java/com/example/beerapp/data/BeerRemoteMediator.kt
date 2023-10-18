package com.example.beerapp.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.beerapp.data.local.BeerEntity
import com.example.beerapp.data.mappers.toBeerEntity
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(//remoteMediators are used when you pagigng between an api and db
    private val beerDb: BeerDatabase,
    private val beerApi: BeerApi
): RemoteMediator<Int, BeerEntity>() {
    override suspend fun load(
        loadType: LoadType,//this is used for UI purpose on the presentation of the paged data
        state: PagingState<Int, BeerEntity>//this is the state of the data already paged and the data about to get paged
    ): MediatorResult {
        return try {
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1 //when refreshed we return the !sst pagekey automatic
                LoadType.PREPEND -> {//this is not supported by this app
                    return MediatorResult.Success(
                        endOfPaginationReached = true//so on success we set the endpagination reached to true
                    )
                }
                LoadType.APPEND -> {//this is what happen when we need the next pag
                    val lastItem = state.lastItemOrNull()//we check if we are at the last item or not
                    if(lastItem == null){//we set what should happen in both senarios
                        1//if we not at the last item we must return first item
                    }else{ //if there more item we load the next item in pages
                        (lastItem.id / state.config.pageSize) + 1 //this logic can be unique to different app depending on if we have id or not
                    }
                }
            }
            //after getting key we make the api call
            delay(2000L)
            val beers = beerApi.getBeers(//this returns a list of items in a page to be shown in the UI
                page = loadKey,
                pageCount = state.config.pageSize
            )
            //then we cache the item in the db
            beerDb.withTransaction { //this will happen while accessing the db
                if(loadType == LoadType.REFRESH) {//if it is bring new data on refresh we want to clear the cache
                    beerDb.dao.clearAll()
                }
                val beerEntities = beers.map { it.toBeerEntity() }
                beerDb.dao.upsertAll(beerEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()//because pages are returned as lists if we are at the last page on the next call if we are the last page the next page call will true an empty list
            )
        }catch (e: IOException){
            MediatorResult.Error(e)
        }catch (e: HttpException){
            MediatorResult.Error(e)
        }
    }
}