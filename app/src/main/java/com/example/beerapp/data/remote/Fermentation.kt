package com.example.beerapp.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fermentation(
    @SerialName("temp")
    val temp: Temp
)