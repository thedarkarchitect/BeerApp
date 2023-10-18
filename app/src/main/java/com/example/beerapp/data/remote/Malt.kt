package com.example.beerapp.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Malt(
    @SerialName("amount")
    val amount: Amount,
    @SerialName("name")
    val name: String
)