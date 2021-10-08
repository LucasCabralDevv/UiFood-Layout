package com.lucascabral.uifood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucascabral.uifood.R
import com.lucascabral.uifood.databinding.FragmentDrinksBinding

class DrinksFragment : Fragment() {

    private lateinit var binding: FragmentDrinksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrinksBinding.inflate(inflater, container, false)
        return binding.root
    }
}