package com.example.beerapp.data.remote


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MashTemp(
    @SerialName("duration")
    @Contextual
    val duration: Any,
    @SerialName("temp")
    val temp: Temp
)