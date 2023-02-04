package com.katerina.morozova.di

import com.katerina.morozova.movie_description_screen.data.repositories.MovieDescriptionRepositoryImpl
import com.katerina.morozova.movie_description_screen.domain.repositories.MovieDescriptionRepository
import com.katerina.morozova.popular_movies_screen.data.repositories.PopularMoviesRepositoryImpl
import com.katerina.morozova.popular_movies_screen.domain.repositories.PopularMoviesRepository
import com.katerina.morozova.popular_movies_screen.data.repositories.SearchPopularMoviesRepositoryImpl
import com.katerina.morozova.popular_movies_screen.domain.repositories.SearchPopularMoviesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun providePopularMoviesRepository(repositoryImpl: PopularMoviesRepositoryImpl):
            PopularMoviesRepository = repositoryImpl

    @Provides
    fun provideMovieDescriptionRepository(repositoryImpl: MovieDescriptionRepositoryImpl):
            MovieDescriptionRepository = repositoryImpl

    @Provides
    fun provideSearchMoviesRepository(repositoryImpl: SearchPopularMoviesRepositoryImpl):
            SearchPopularMoviesRepository = repositoryImpl
}