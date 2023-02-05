package com.katerina.morozova.domain.interactors

import com.katerina.morozova.domain.repositories.MovieDescriptionRepository
import javax.inject.Inject

class MovieDescriptionInteractor @Inject constructor(
    private val mainDescriptionRepository: MovieDescriptionRepository
) {

    suspend fun getMovieDescription(movieId: Int) =
        mainDescriptionRepository.getMovieDescription(movieId)
}