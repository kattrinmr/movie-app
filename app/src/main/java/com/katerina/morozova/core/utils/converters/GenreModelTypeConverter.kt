package com.katerina.morozova.core.utils.converters

import androidx.room.TypeConverter
import com.katerina.morozova.core.models.GenreModel

class GenreModelTypeConverter {
    @TypeConverter
    fun fromGenreModelList(genreModelList: List<GenreModel>): String {
        return genreModelList.joinToString(",") { it.genre }
    }

    @TypeConverter
    fun toGenreModelList(genres: String): List<GenreModel> {
        return genres.split(",").map { GenreModel(it) }
    }
}