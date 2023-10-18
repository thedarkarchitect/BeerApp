package com.example.beerapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.beerapp.data.local.BeerEntity
import com.example.beerapp.data.mappers.toBeer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    pager: Pager<Int, BeerEntity> // we going to recieve a page from the db after the
): ViewModel(){
    val beerPagingFlow = pager
        .flow
        .map {pagingData ->
            pagingData.map { entity ->
                entity.toBeer()
            }
        }
    .cachedIn(viewModelScope)
}