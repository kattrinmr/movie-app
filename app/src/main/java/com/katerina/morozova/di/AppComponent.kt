package com.katerina.morozova.di

import android.app.Application
import com.katerina.morozova.favorite_movies_screen.ui.fragments.FavoriteFragment
import com.katerina.morozova.popular_movies_screen.ui.fragments.PopularFragment
import com.katerina.morozova.search_screen.ui.fragments.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(fragment: PopularFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(fragment: SearchFragment)
}