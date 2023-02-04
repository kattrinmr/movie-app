package com.katerina.morozova.core.room.daos

import androidx.room.*
import com.katerina.morozova.core.room.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Delete
    suspend fun deleteMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM movies WHERE filmId = :filmId")
    fun getMovieByFilmId(filmId: Int): Flow<MovieEntity>
}
