package com.example.beerapp.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Temp(
    @SerialName("unit")
    val unit: String,
    @SerialName("value")
    val value: Int
)