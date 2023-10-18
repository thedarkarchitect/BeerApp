package com.example.beerapp.data.remote


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Method(
    @SerialName("fermentation")
    val fermentation: Fermentation,
    @SerialName("mash_temp")
    val mashTemp: List<MashTemp>,
    @SerialName("twist")
    @Contextual
    val twist: Any
)