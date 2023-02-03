package com.katerina.morozova.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.katerina.morozova.core.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    @Binds
    @Singleton
    abstract fun provideViewModelFactory(factory: ViewModelFactory<ViewModel>): ViewModelProvider.Factory
}