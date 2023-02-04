package com.katerina.morozova.di

import android.app.Application
import com.katerina.morozova.favorite_movies_screen.ui.fragments.FavoriteFragment
import com.katerina.morozova.movie_description_screen.ui.fragments.MovieDescriptionFragment
import com.katerina.morozova.popular_movies_screen.ui.fragments.PopularFragment
import com.katerina.morozova.popular_movies_screen.ui.fragments.SearchPopularMoviesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoriesModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(fragment: PopularFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(fragment: SearchPopularMoviesFragment)
    fun inject(fragment: MovieDescriptionFragment)
}