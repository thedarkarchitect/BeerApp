package com.example.beerapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.beerapp.domain.model.Beer

@Entity
data class BeerEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String?,
)