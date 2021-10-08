package com.lucascabral.uifood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucascabral.uifood.R
import com.lucascabral.uifood.databinding.FragmentRestaurantsBinding

class RestaurantsFragment : Fragment() {

    private lateinit var binding: FragmentRestaurantsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestaurantsBinding.inflate(inflater, container, false)
        return binding.root
    }
}