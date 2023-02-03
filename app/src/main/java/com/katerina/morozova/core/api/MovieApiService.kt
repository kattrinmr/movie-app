package com.katerina.morozova.core.api

import com.katerina.morozova.core.utils.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("films/top")
    suspend fun getMovies(
        @Query("type") type: String = "TOP_100_POPULAR_FILMS",
        @Query("page") page: Int = 1
    ): MovieResponse

    //    @GET("films/{id}")
    //    suspend fun getMovieDescription(@Path("id") id: Int): MovieDescriptionResponse

}