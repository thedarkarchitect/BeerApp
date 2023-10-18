package com.example.beerapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.beerapp.data.local.BeerEntity

@Database(
    entities = [BeerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BeerDatabase : RoomDatabase(){
    abstract val dao: BeerDao
}