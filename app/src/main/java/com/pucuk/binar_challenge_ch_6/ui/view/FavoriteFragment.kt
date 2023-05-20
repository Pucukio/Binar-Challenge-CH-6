package com.pucuk.binar_challenge_ch_6.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pucuk.binar_challenge_ch_6.R
import com.pucuk.binar_challenge_ch_6.data.database.DatabaseFav
import com.pucuk.binar_challenge_ch_6.databinding.FragmentFavoriteBinding
import com.pucuk.binar_challenge_ch_6.databinding.FragmentHomeBinding
import com.pucuk.binar_challenge_ch_6.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {


    private val viewModel: FavoriteViewModel by viewModels()
    lateinit var _binding: FragmentFavoriteBinding
    private var favDB: DatabaseFav? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)

        favDB = DatabaseFav.getInstance(requireContext())
        viewModel.session()

        _binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_favoriteFragment_to_homeFragment)
            true
        }
    }
}