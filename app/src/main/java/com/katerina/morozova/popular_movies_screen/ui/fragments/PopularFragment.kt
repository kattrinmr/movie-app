package com.katerina.morozova.popular_movies_screen.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.katerina.morozova.MoviesApp
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.NetworkResponse
import com.katerina.morozova.core.utils.ViewModelFactory
import com.katerina.morozova.databinding.FragmentPopularBinding
import com.katerina.morozova.core.ui.adapters.MoviesAdapter
import com.katerina.morozova.popular_movies_screen.ui.viewmodels.PopularMoviesViewModel
import javax.inject.Inject

class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding
    private lateinit var moviesAdapter: MoviesAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<PopularMoviesViewModel>
    private lateinit var viewModel: PopularMoviesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MoviesApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(inflater)
        moviesAdapter = MoviesAdapter(
            openMovieDescription = this::openMovieDescription,
            addMovieToFavorites = this::addMovieToFavorites
        )
        binding.rvMovies.apply {
            adapter = moviesAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = viewModelFactory.getViewModel(this)

        binding.btnFavorites.setOnClickListener {
            findNavController().navigate(PopularFragmentDirections.actionPopularFragmentToFavoriteFragment())
        }

        binding.btnSearch.setOnClickListener {
            findNavController().navigate(PopularFragmentDirections.actionPopularFragmentToSearchFragment())
        }

        viewModel.movieModelResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Loading -> {
                    binding.progressBar.isVisible = it.isLoading
                }

                is NetworkResponse.Failure -> {
                    Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                }

                is NetworkResponse.Success -> {
                    moviesAdapter.updateMovies(it.data)
                    binding.progressBar.isVisible = false
                }
            }
        }
    }

    private fun openMovieDescription(movieId: String) {
        findNavController().navigate(
            PopularFragmentDirections.actionPopularFragmentToMovieDescriptionFragment2(movieId)
        )
    }

    private fun addMovieToFavorites(movie: MovieModel) {
        viewModel.addMovieToFavorite(movie)
    }
}