package com.lucascabral.uifood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucascabral.uifood.databinding.FragmentMarketplaceBinding

class MarketplaceFragment : Fragment() {

    private lateinit var binding: FragmentMarketplaceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMarketplaceBinding.inflate(inflater, container, false)
        return binding.root
    }
}