package com.tutoriales.mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tutoriales.mvvm.data.database.dao.QuoteDao
import com.tutoriales.mvvm.data.database.entities.QuoteEntity

@Database([QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}