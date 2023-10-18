package com.example.beerapp.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class wholeBeerDtoItem(
    @SerialName("abv")
    val abv: Double,
    @SerialName("attenuation_level")
    val attenuationLevel: Int,
    @SerialName("boil_volume")
    val boilVolume: BoilVolume,
    @SerialName("brewers_tips")
    val brewersTips: String,
    @SerialName("contributed_by")
    val contributedBy: String,
    @SerialName("description")
    val description: String,
    @SerialName("ebc")
    val ebc: Int,
    @SerialName("first_brewed")
    val firstBrewed: String,
    @SerialName("food_pairing")
    val foodPairing: List<String>,
    @SerialName("ibu")
    val ibu: Double,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("ingredients")
    val ingredients: Ingredients,
    @SerialName("method")
    val method: Method,
    @SerialName("name")
    val name: String,
    @SerialName("ph")
    val ph: Double,
    @SerialName("srm")
    val srm: Int,
    @SerialName("tagline")
    val tagline: String,
    @SerialName("target_fg")
    val targetFg: Int,
    @SerialName("target_og")
    val targetOg: Double,
    @SerialName("volume")
    val volume: Volume
)