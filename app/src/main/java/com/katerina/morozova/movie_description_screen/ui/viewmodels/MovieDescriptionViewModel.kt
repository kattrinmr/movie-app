package com.katerina.morozova.movie_description_screen.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katerina.morozova.core.models.MovieDescriptionModel
import com.katerina.morozova.core.utils.responses.NetworkResponse
import com.katerina.morozova.movie_description_screen.domain.interactors.MovieDescriptionInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDescriptionViewModel @Inject constructor(
    private val interactor: MovieDescriptionInteractor
): ViewModel() {

    private var _movieDescriptionResponse = MutableLiveData<NetworkResponse<MovieDescriptionModel>>()
    val movieDescriptionResponse: LiveData<NetworkResponse<MovieDescriptionModel>> = _movieDescriptionResponse

    fun fetchMovieDescription(movieId: Int) {
        viewModelScope.launch {
            interactor.getMovieDescription(movieId).collect {
                _movieDescriptionResponse.postValue(it)
            }
        }
    }

}