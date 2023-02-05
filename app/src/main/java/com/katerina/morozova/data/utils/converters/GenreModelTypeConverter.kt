package com.katerina.morozova.data.utils.converters

import androidx.room.TypeConverter
import com.katerina.morozova.data.models.GenreModel

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