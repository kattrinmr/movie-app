package com.katerina.morozova.core.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.katerina.morozova.core.models.CountryModel
import com.katerina.morozova.core.models.GenreModel
import com.katerina.morozova.core.utils.converters.CountryModelTypeConverter
import com.katerina.morozova.core.utils.converters.GenreModelTypeConverter

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val filmId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val posterUrl: String,
    val year: String,
    val description: String?,
    val isFavorite: Boolean,
    @TypeConverters(CountryModelTypeConverter::class) val countries: List<CountryModel>,
    @TypeConverters(GenreModelTypeConverter::class) val genres: List<GenreModel>
)
