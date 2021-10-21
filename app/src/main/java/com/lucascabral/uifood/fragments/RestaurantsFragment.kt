package com.lucascabral.uifood.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lucascabral.uifood.R
import com.lucascabral.uifood.databinding.FragmentRestaurantsBinding
import com.lucascabral.uifood.extensions.toChip
import com.lucascabral.uifood.model.FilterItem

class RestaurantsFragment : Fragment(R.layout.fragment_restaurants) {

    private lateinit var binding: FragmentRestaurantsBinding

    private var filters = arrayOf(
        FilterItem(1,text = "Ordenar", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(2,text = "Para retirar", icon = R.drawable.ic_directions_walk),
        FilterItem(3,text = "Entrega grátis"),
        FilterItem(4,text = "Vale-refeição", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(5,text = "Distância", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(6,text = "Super Restaurante"),
        FilterItem(7,text = "Filtros", closeIcon = R.drawable.ic_filter_list)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRestaurantsBinding.bind(view)

        binding.apply {
            filters.forEach { filterItem ->
                this.chipGroupFilter.addView(filterItem.toChip(requireContext()))
            }
        }
    }
}