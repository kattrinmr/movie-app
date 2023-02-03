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
import com.katerina.morozova.core.utils.NetworkResponse
import com.katerina.morozova.core.utils.ViewModelFactory
import com.katerina.morozova.databinding.FragmentPopularBinding
import com.katerina.morozova.popular_movies_screen.ui.adapters.ClickInterface
import com.katerina.morozova.popular_movies_screen.ui.adapters.PopularMoviesAdapter
import com.katerina.morozova.popular_movies_screen.ui.viewmodels.PopularMoviesViewModel
import javax.inject.Inject

class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding
    lateinit var popularMoviesAdapter: PopularMoviesAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<PopularMoviesViewModel>
    lateinit var viewModel: PopularMoviesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MoviesApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularBinding.inflate(inflater)
        popularMoviesAdapter = PopularMoviesAdapter()
        binding.rvMovies.adapter = popularMoviesAdapter
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

        popularMoviesAdapter.setItemClick(object : ClickInterface<MovieModel> {
            override fun onClick(data: MovieModel) {
                Toast.makeText(requireContext(), "Переход к описанию фильма", Toast.LENGTH_SHORT)
                    .show()
            }
        })

//        popularMoviesAdapter.setItemLongClick(object : LongClickInterface<MovieModel> {
//            override fun onLongClick(data: MovieModel) {
//                Toast.makeText(requireContext(), "Типа добавили в избранное", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        })

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
                    popularMoviesAdapter.updateMovies(it.data)
                    binding.progressBar.isVisible = false
                }
            }
        }
    }
}