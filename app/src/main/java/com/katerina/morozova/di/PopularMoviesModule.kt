package com.katerina.morozova.di

import com.katerina.morozova.popular_movies_screen.data.repositories.PopularMoviesRepositoryImpl
import com.katerina.morozova.popular_movies_screen.domain.repositories.PopularMoviesRepository
import dagger.Module
import dagger.Provides

@Module
class PopularMoviesModule {

    @Provides
    fun providePopularMoviesRepository(repositoryImpl: PopularMoviesRepositoryImpl):
            PopularMoviesRepository = repositoryImpl
}