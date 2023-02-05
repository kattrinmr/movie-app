package com.katerina.morozova.di

import com.katerina.morozova.data.repositories.MovieDescriptionRepositoryImpl
import com.katerina.morozova.domain.repositories.MovieDescriptionRepository
import com.katerina.morozova.data.repositories.PopularMoviesRepositoryImpl
import com.katerina.morozova.domain.repositories.PopularMoviesRepository
import com.katerina.morozova.data.repositories.SearchPopularMoviesRepositoryImpl
import com.katerina.morozova.domain.repositories.SearchPopularMoviesRepository
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