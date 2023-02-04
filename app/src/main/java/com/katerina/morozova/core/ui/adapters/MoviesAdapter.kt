package com.katerina.morozova.core.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.databinding.ItemMovieBinding

class MoviesAdapter(
    private val openMovieDescription: (movieId: String) -> Unit = { movieId ->
        Log.d("PopularMoviesAdapter", "Open $movieId")
    }
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    var moviesList = mutableListOf<MovieModel>()

    fun updateMovies(movies: List<MovieModel>) {
        val diffCallback = object : DiffUtil.Callback() {

            override fun getOldListSize(): Int = moviesList.size
            override fun getNewListSize(): Int = movies.size

            override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
                return moviesList[oldPosition].filmId == movies[newPosition].filmId
            }

            override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
                return (moviesList[oldPosition].filmId == movies[newPosition].filmId
                        && moviesList[oldPosition].posterUrl == movies[newPosition].posterUrl)
            }
        }

        val diffResult = DiffUtil.calculateDiff(diffCallback)
        moviesList = movies.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }

    abstract inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(movie: MovieModel, openMovieDescription: (movieId: String) -> Unit)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList[position], openMovieDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return PopularMovieViewHolder(binding, openMovieDescription)
    }


    inner class PopularMovieViewHolder(
        private val binding: ItemMovieBinding,
        private val action: (movieId: String) -> Unit,
    ) : MovieViewHolder(binding.root) {

        override fun bind(movie: MovieModel, openMovieDescription: (movieId: String) -> Unit) {
            with(binding) {
                if (movie.nameRu == null) tvMovieTitle.text = movie.nameEn
                else tvMovieTitle.text = movie.nameRu

                tvMovieDescription.text =
                    "${movie.genres.joinToString(", ") { it.genre }} (${movie.year})"

                Glide
                    .with(imgMovie.context)
                    .load(movie.posterUrl)
                    .centerCrop()
                    .into(imgMovie)

                root.setOnClickListener {
                    openMovieDescription(movie.filmId.toString())
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}