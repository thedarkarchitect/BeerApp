package com.example.beerapp.data.remote

import com.example.beerapp.data.local.BeerEntity

data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val first_brewed: String,
    val image_url: String?
)
