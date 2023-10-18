package com.example.beerapp.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.beerapp.data.local.BeerEntity

@Dao
interface BeerDao {
    @Upsert
    suspend fun upsertAll(beers: List<BeerEntity>)//this receives a list from a page to insert and update

    @Query("SELECT * FROM beerentity")
    fun pagingSource(): PagingSource<Int, BeerEntity>//this is returning a paging resouce cause its using the paging library that requires this type before its a Flow

    @Query("DELETE FROM beerentity")
    suspend fun clearAll()

}