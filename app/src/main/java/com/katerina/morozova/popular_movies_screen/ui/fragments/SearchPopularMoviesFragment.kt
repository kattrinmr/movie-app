package com.katerina.morozova.popular_movies_screen.ui.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.katerina.morozova.MoviesApp
import com.katerina.morozova.core.ui.adapters.MoviesAdapter
import com.katerina.morozova.core.utils.responses.NetworkMovieResponse
import com.katerina.morozova.core.utils.ViewModelFactory
import com.katerina.morozova.databinding.FragmentPopularMoviesSearchBinding
import com.katerina.morozova.popular_movies_screen.ui.viewmodels.SearchPopularMoviesViewModel
import javax.inject.Inject


class SearchPopularMoviesFragment : Fragment() {

    private lateinit var binding: FragmentPopularMoviesSearchBinding
    private lateinit var moviesAdapter: MoviesAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<SearchPopularMoviesViewModel>
    private lateinit var viewModel: SearchPopularMoviesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MoviesApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularMoviesSearchBinding.inflate(inflater)
        moviesAdapter = MoviesAdapter(openMovieDescription = this::openMovieDescription)
        binding.rvMovies.apply {
            adapter = moviesAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = viewModelFactory.getViewModel(this)

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                moviesAdapter.updateMovies(listOf())
                viewModel.fetchSearchedMovies(s.toString())

                viewModel.searchedMovieModelResponse.observe(viewLifecycleOwner) {
                    when (it) {
                        is NetworkMovieResponse.Loading -> {
                            binding.imgError.visibility = View.GONE
                            binding.txtErrorUp.visibility = View.GONE
                            binding.txtErrorDown.visibility = View.GONE
                            binding.progressBar.isVisible = it.isLoading
                        }

                        is NetworkMovieResponse.Failure -> {
                            if (it.errorMessage == "Unable to resolve host \"kinopoiskapiunofficial.tech\": No address associated with hostname") {
                                binding.imgError.visibility = View.VISIBLE
                                binding.txtErrorUp.visibility = View.VISIBLE
                                binding.txtErrorDown.visibility = View.VISIBLE
                            } else Toast.makeText(
                                requireContext(),
                                it.errorMessage,
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            binding.progressBar.isVisible = false
                        }

                        is NetworkMovieResponse.Success -> {
                            binding.imgError.visibility = View.GONE
                            binding.txtErrorUp.visibility = View.GONE
                            binding.txtErrorDown.visibility = View.GONE
                            moviesAdapter.updateMovies(it.data)
                            binding.progressBar.isVisible = false
                        }
                    }
                }
            }

        })
    }

    private fun openMovieDescription(movieId: String) {
        findNavController().navigate(
            SearchPopularMoviesFragmentDirections.actionSearchFragmentToMovieDescriptionFragment(
                movieId
            )
        )
    }
}