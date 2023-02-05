package com.katerina.morozova.popular_movies_screen.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.NetworkResponse
import com.katerina.morozova.popular_movies_screen.domain.interactors.PopularMoviesInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val interactor: PopularMoviesInteractor
): ViewModel() {

    private var _movieModelResponse = MutableLiveData<NetworkResponse<List<MovieModel>>>()
    val movieModelResponse: LiveData<NetworkResponse<List<MovieModel>>> = _movieModelResponse

    init {
        fetchAllMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            interactor.getPopularMovies().collect {
                _movieModelResponse.postValue(it)
            }
        }
    }

    fun addMovieToFavorite(movie: MovieModel) {
        viewModelScope.launch {
            interactor.insertMovie(movie)
        }
    }
}