package com.example.beerapp.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.beerapp.domain.model.Beer
import kotlinx.coroutines.flow.Flow


//fun <T: Any> LazyListScope.items(
//    items: LazyPagingItems<T>,
//    key: ( (T) -> Any )? = null,
//    contentType: ( (T) -> Any )? = null,
//    itemContent: @Composable LazyItemScope.(T) -> Unit
//) {
//    items(
//        items.itemCount,
//        key = items.itemKey(key),
//        contentType = items.itemContentType(contentType)
//    ) loop@ { i ->
//        val item = items[i] ?: return@loop
//        itemContent(item)
//    }
//}

@Composable
fun BeerScreen(
    modifier: Modifier = Modifier,
    beers: LazyPagingItems<Beer>
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = beers.loadState){//load state is an object the represents the loading state of a beers being page
        if(beers.loadState.refresh is LoadState.Error){
            Toast.makeText(
                context,
                "Error: "+(beers.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = modifier.fillMaxSize()){
        if(beers.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(count = beers.itemCount){beerIndex ->
                    val item = beers[beerIndex]
                    if(item != null){
                        BeerItem(
                            beer = item,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                item{
                    if(beers.loadState.append is LoadState.Loading){
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }

}
