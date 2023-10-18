package com.example.beerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.beerapp.presentation.BeerScreen
import com.example.beerapp.presentation.BeerViewModel
import com.example.beerapp.ui.theme.BeerAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerAppTheme {
                val viewModel = hiltViewModel<BeerViewModel>()
                val beers = viewModel.beerPagingFlow.collectAsLazyPagingItems()

                BeerScreen(
                    beers = beers
                )
            }
        }
    }
}

