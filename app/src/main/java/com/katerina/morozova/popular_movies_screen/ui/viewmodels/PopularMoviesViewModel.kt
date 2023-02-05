package com.katerina.morozova.popular_movies_screen.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.StatusResponse
import com.katerina.morozova.favorite_movies_screen.domain.interactors.FavoriteInteractor
import com.katerina.morozova.popular_movies_screen.domain.interactors.PopularMoviesInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesInteractor: PopularMoviesInteractor,
    private val favoriteInteractor: FavoriteInteractor
) : ViewModel() {

    private var _movieModelResponse = MutableLiveData<StatusResponse<List<MovieModel>>>()
    val movieModelResponse: LiveData<StatusResponse<List<MovieModel>>> = _movieModelResponse
    private var _isFavourite = MutableLiveData<Pair<Int, Boolean>?>()
    val isFavourite: LiveData<Pair<Int, Boolean>?>
        get() = _isFavourite

    private val _favoriteResponse = MutableLiveData<StatusResponse<List<MovieModel>>>()
    val favoriteResponse: LiveData<StatusResponse<List<MovieModel>>> = _favoriteResponse

    init {
        fetchAllMovies()
        fetchFavoriteMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            popularMoviesInteractor.getPopularMovies().collect {
                _movieModelResponse.postValue(it)
            }
        }
    }

    fun addMovieToFavorite(movie: MovieModel) {
        viewModelScope.launch {
            popularMoviesInteractor.insertMovie(movie)
        }
    }

    fun checkIfFavourite(movie: MovieModel): Boolean {
        viewModelScope.launch {
            val isFav = popularMoviesInteractor.checkIfFavourite(movie.filmId)

            if (isFav) {
                popularMoviesInteractor.removeMovie(movie)
            } else {
                popularMoviesInteractor.insertMovie(movie)
            }
            _isFavourite.postValue(Pair(movie.filmId, !isFav))
        }

        return true
    }

    fun fetchFavoriteMovies() {
        viewModelScope.launch {
            favoriteInteractor.getAllFavoriteMovies().collect {
                _favoriteResponse.postValue(it)
            }
        }
    }

    fun removeMovieFromFavorite(movie: MovieModel) {
        viewModelScope.launch {
            favoriteInteractor.removeMovie(movie)
            _isFavourite.postValue(Pair(movie.filmId, false))
            updateMovieStatus(movie.filmId, false)
        }
    }

    fun updateMovieStatus(movieId: Int, isFav: Boolean) {
        when(_movieModelResponse.value as StatusResponse<List<MovieModel>>) {
            is StatusResponse.Success -> {
                (_movieModelResponse.value as StatusResponse.Success<List<MovieModel>>)
                    .data.first {
                        it.filmId == movieId
                    }.isFavorite = isFav
            }
            else -> {}
        }
    }

    fun clearFavStatus() {
        _isFavourite.postValue(null)
    }
}