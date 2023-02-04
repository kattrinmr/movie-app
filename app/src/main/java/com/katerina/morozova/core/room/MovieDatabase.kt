package com.katerina.morozova.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.katerina.morozova.core.room.daos.MovieDao
import com.katerina.morozova.core.room.entities.CountryModelTypeConverter
import com.katerina.morozova.core.room.entities.GenreModelTypeConverter
import com.katerina.morozova.core.room.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(CountryModelTypeConverter::class, GenreModelTypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
