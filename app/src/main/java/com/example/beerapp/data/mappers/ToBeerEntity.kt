package com.example.beerapp.data.mappers

import com.example.beerapp.data.local.BeerEntity
import com.example.beerapp.data.remote.BeerDto

//mapper to turn what is in the dto to the db
fun  BeerDto.toBeerEntity(): BeerEntity {//extension function
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}