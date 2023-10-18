package com.example.beerapp.domain.model

//this data class communicates with the dto thru mapping and opens up to UI
data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val firstbrewed: String,
    val description: String,
    val imageUrl: String?,
)
