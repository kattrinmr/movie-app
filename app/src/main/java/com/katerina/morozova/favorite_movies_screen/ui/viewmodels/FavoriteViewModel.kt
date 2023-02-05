package com.katerina.morozova.favorite_movies_screen.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.RoomResponse
import com.katerina.morozova.favorite_movies_screen.domain.interactors.FavoriteInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val interactor: FavoriteInteractor
) : ViewModel() {

    private val _favoriteResponse = MutableLiveData<RoomResponse<List<MovieModel>>>()
    val favoriteResponse: LiveData<RoomResponse<List<MovieModel>>> = _favoriteResponse

    init {
        fetchFavoriteMovies()
    }

    fun fetchFavoriteMovies() {
        viewModelScope.launch {
            interactor.getAllFavoriteMovies().collect {
                _favoriteResponse.postValue(it)
            }
        }
    }

    fun removeMovieFromFavorite(movie: MovieModel) {
        viewModelScope.launch {
            interactor.removeMovie(movie)
        }
    }

}

