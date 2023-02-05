package com.katerina.morozova.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.katerina.morozova.data.room.daos.MovieDao
import com.katerina.morozova.data.utils.converters.CountryModelTypeConverter
import com.katerina.morozova.data.utils.converters.GenreModelTypeConverter
import com.katerina.morozova.data.room.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(CountryModelTypeConverter::class, GenreModelTypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
