package com.example.beerapp.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ingredients(
    @SerialName("hops")
    val hops: List<Hop>,
    @SerialName("malt")
    val malt: List<Malt>,
    @SerialName("yeast")
    val yeast: String
)