package com.katerina.morozova.favorite_movies_screen.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.katerina.morozova.MoviesApp
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.ui.adapters.MoviesAdapter
import com.katerina.morozova.core.utils.ViewModelFactory
import com.katerina.morozova.core.utils.responses.StatusResponse
import com.katerina.morozova.databinding.FragmentFavoriteBinding
import com.katerina.morozova.popular_movies_screen.ui.viewmodels.MoviesViewModel
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var moviesAdapter: MoviesAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MoviesViewModel>
    private val viewModel by activityViewModels<MoviesViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MoviesApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater)
        moviesAdapter = MoviesAdapter(
            openMovieDescription = this::openMovieDescription,
            removeMovieFromFavorites = this::removeMovieFromFavorites
        )
        binding.rvMovies.apply {
            adapter = moviesAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel = viewModelFactory.getViewModel(this)

        binding.btnPopulars.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.favoriteResponse.observe(viewLifecycleOwner) {
            when (it) {
                is StatusResponse.Loading -> {
                    binding.progressBar.isVisible = it.isLoading
                }

                is StatusResponse.Failure -> {
                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                }

                is StatusResponse.Success -> {
                    moviesAdapter.updateMovies(it.data)
                    binding.progressBar.isVisible = false
                }
            }
        }
    }

    private fun openMovieDescription(movieId: String) {
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToMovieDescriptionFragment2(movieId)
        )
    }

    private fun removeMovieFromFavorites(movie: MovieModel) {
        viewModel.removeMovieFromFavorite(movie)
        viewModel.fetchFavoriteMovies()
    }

}