package com.katerina.morozova.popular_movies_screen.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.databinding.ItemMovieBinding

class PopularMoviesAdapter() : RecyclerView.Adapter<PopularMoviesAdapter.MovieViewHolder>() {

    var movieModels = mutableListOf<MovieModel>()
    private var clickInterface: ClickInterface<MovieModel>? = null
//    private var longClickInterface: LongClickInterface<MovieModel>? = null

    fun updateMovies(movieModels: List<MovieModel>) {
        this.movieModels = movieModels.toMutableList()
        notifyItemRangeInserted(0, movieModels.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieModels[position]
        holder.view.tvMovieTitle.text = movie.nameRu
        holder.view.tvMovieDescription.text =
            "${movie.genres.joinToString(", ") { it.genre }} (${movie.year})"
        Glide
            .with(holder.view.imgMovie.context)
            .load(movie.posterUrl)
            .centerCrop()
            .into(holder.view.imgMovie)

//        holder.view.itemMovie.setOnLongClickListener {
//            holder.view.imgFavorite.visibility = View.VISIBLE
//            longClickInterface?.onLongClick(movie)
//            true
//        }

        holder.view.itemMovie.setOnClickListener {
            clickInterface?.onClick(movie)
        }
    }

    override fun getItemCount(): Int {
        return movieModels.size
    }

    fun setItemClick(clickInterface: ClickInterface<MovieModel>) {
        this.clickInterface = clickInterface
    }

//    fun setItemLongClick(longClickInterface: LongClickInterface<MovieModel>) {
//        this.longClickInterface = longClickInterface
//    }

    class MovieViewHolder(val view: ItemMovieBinding) : RecyclerView.ViewHolder(view.root)
}

interface ClickInterface<T> {
    fun onClick(data: T)
}

//interface LongClickInterface<T> {
//    fun onLongClick(data: T)
//}