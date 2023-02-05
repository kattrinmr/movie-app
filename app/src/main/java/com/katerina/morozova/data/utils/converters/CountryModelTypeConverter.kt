package com.katerina.morozova.data.utils.converters

import androidx.room.TypeConverter
import com.katerina.morozova.data.models.CountryModel

class CountryModelTypeConverter {
    @TypeConverter
    fun fromCountryModelList(countryModelList: List<CountryModel>): String {
        return countryModelList.joinToString(",") { it.country }
    }

    @TypeConverter
    fun toCountryModelList(countries: String): List<CountryModel> {
        return countries.split(",").map { CountryModel(it) }
    }
}