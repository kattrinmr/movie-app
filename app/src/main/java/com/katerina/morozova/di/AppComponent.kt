package com.katerina.morozova.di

import android.app.Application
import com.katerina.morozova.ui.fragments.FavoriteFragment
import com.katerina.morozova.ui.fragments.MovieDescriptionFragment
import com.katerina.morozova.ui.fragments.PopularFragment
import com.katerina.morozova.ui.fragments.SearchPopularMoviesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, RepositoriesModule::class, ViewModelModule::class,
        RoomModule::class]
)
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