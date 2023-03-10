package com.katerina.morozova.data.api

import com.katerina.morozova.data.utils.responses.MovieDescriptionResponse
import com.katerina.morozova.data.utils.responses.MovieResponse
import com.katerina.morozova.data.utils.responses.SearchMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("v2.2/films/top")
    suspend fun getMovies(
        @Query("type") type: String = "TOP_100_POPULAR_FILMS",
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("v2.2/films/{id}")
    suspend fun getMovieDescription(@Path("id") id: Int): MovieDescriptionResponse

    @GET("v2.1/films/search-by-keyword")
    suspend fun getSearchedMovies(
        @Query("keyword") keyword: String,
        @Query("page") page: Int = 1
    ): SearchMovieResponse

}