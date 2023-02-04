package com.katerina.morozova.movie_description_screen.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.katerina.morozova.MoviesApp
import com.katerina.morozova.core.utils.NetworkResponse
import com.katerina.morozova.core.utils.ViewModelFactory
import com.katerina.morozova.databinding.FragmentMovieDescriptionBinding
import com.katerina.morozova.movie_description_screen.ui.viewmodels.MovieDescriptionViewModel
import javax.inject.Inject

class MovieDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentMovieDescriptionBinding
    private lateinit var movieId: String

    private val args: MovieDescriptionFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MovieDescriptionViewModel>
    private lateinit var viewModel: MovieDescriptionViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MoviesApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDescriptionBinding.inflate(inflater)
        movieId = args.movieId
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = viewModelFactory.getViewModel(this)
        Log.d("MovieDescription", movieId)
        viewModel.fetchMovieDescription(movieId.toInt())

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.movieDescriptionResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Loading -> {
                    binding.progressBar.isVisible = it.isLoading
                }

                is NetworkResponse.Failure -> {
                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                }

                is NetworkResponse.Success -> {
                    binding.progressBar.isVisible = false

                    Glide
                        .with(binding.imgMoviePoster.context)
                        .load(it.data.posterUrl)
                        .centerCrop()
                        .into(binding.imgMoviePoster)

                    if (it.data.nameRu == null) binding.tvMovieTitle.text = it.data.nameEn
                    else binding.tvMovieTitle.text = it.data.nameRu
                    if (it.data.description != null) binding.tvMovieDescription.text = it.data.description
                    binding.tvMovieCountries.text = it.data.countries.joinToString(", ") { country ->
                        country.country
                    }
                    binding.tvMovieGenres.text = it.data.genres.joinToString(", ") { genre ->
                        genre.genre
                    }
                    binding.tvMovieYear.text = it.data.year
                }

            }
        }


    }


}