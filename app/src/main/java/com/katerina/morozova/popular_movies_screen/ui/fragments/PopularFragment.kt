package com.katerina.morozova.popular_movies_screen.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.katerina.morozova.databinding.FragmentPopularBinding

class PopularFragment : Fragment() {

    private lateinit var binding: FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFavorites.setOnClickListener {
            findNavController().navigate(PopularFragmentDirections.actionPopularFragmentToFavoriteFragment())
        }

        binding.btnSearch.setOnClickListener {
            findNavController().navigate(PopularFragmentDirections.actionPopularFragmentToSearchFragment())
        }
    }


}