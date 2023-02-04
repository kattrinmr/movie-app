package com.katerina.morozova.movie_description_screen.domain.interactors

import com.katerina.morozova.movie_description_screen.domain.repositories.MovieDescriptionRepository
import javax.inject.Inject

class MovieDescriptionInteractor @Inject constructor(
    private val mainDescriptionRepository: MovieDescriptionRepository
) {

    suspend fun getMovieDescription(movieId: Int) =
        mainDescriptionRepository.getMovieDescription(movieId)
}