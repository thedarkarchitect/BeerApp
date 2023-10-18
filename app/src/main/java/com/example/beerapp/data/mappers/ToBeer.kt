package com.example.beerapp.data.mappers

import com.example.beerapp.data.local.BeerEntity
import com.example.beerapp.domain.model.Beer

//this maps the db to the domain model used in the UI
fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstbrewed =  firstBrewed,
        imageUrl = imageUrl
    )
}