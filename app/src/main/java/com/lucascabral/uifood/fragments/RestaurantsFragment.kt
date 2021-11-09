package com.lucascabral.uifood.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.lucascabral.uifood.BannerView
import com.lucascabral.uifood.CategoryView
import com.lucascabral.uifood.R
import com.lucascabral.uifood.databinding.FragmentRestaurantsBinding
import com.lucascabral.uifood.extensions.toChip
import com.lucascabral.uifood.model.Banner
import com.lucascabral.uifood.model.Category
import com.lucascabral.uifood.model.FilterItem

class RestaurantsFragment : Fragment(R.layout.fragment_restaurants) {

    private lateinit var binding: FragmentRestaurantsBinding

    private val categoryAdapter = ATAdapter({
        CategoryView(it)
    })

    private val bannerAdapter = ATAdapter({
        BannerView(it)
    })

    private var filters = arrayOf(
        FilterItem(1, text = "Ordenar", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(2, text = "Para retirar", icon = R.drawable.ic_directions_walk),
        FilterItem(3, text = "Entrega grátis"),
        FilterItem(4, text = "Vale-refeição", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(5, text = "Distância", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(6, text = "Super Restaurante"),
        FilterItem(7, text = "Filtros", closeIcon = R.drawable.ic_filter_list)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRestaurantsBinding.bind(view)

        categoryAdapter.items = arrayListOf(
            Category(
                1,
                "https://www.ifood.com.br/static/images/categories/market.png",
                "Mercado",
                0xFFB6D048
            ),
            Category(
                2,
                "https://www.ifood.com.br/static/images/categories/restaurant.png",
                "Restaurantes",
                0xFFE91D2D
            ),
            Category(
                3,
                "https://www.ifood.com.br/static/images/categories/drinks.png",
                "Bebidas",
                0xFFF6D553
            ),
            Category(
                4,
                "https://www.ifood.com.br/static/images/categories/express.png",
                "Express",
                0xFFFF0000
            ),
            Category(
                5,
                "https://parceiros.ifood.com.br/static/media/salad.9db040c0.png",
                "Saudável",
                0xFFE91D2D
            ),
            Category(
                6,
                "https://www.nicepng.com/png/detail/404-4048244_coxinha-em-png-coxinha-png.png",
                "Salgados",
                0xFF8C60CC
            )
        )

        bannerAdapter.items = arrayListOf(
            Banner(
                1,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/itensBasicosNOV21Principal_zE1X.png"
            ),
            Banner(
                2,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/Bebidas40offPrincipal_cljA.png"
            ),
            Banner(
                3,
                "https://static-images.ifood.com.br/image/upload/t_high/discoveries/MerceariaeMatinaisPrincipal_mfDO.png"
            )
        )

        binding.apply {
            rvCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvCategory.adapter = categoryAdapter

            rvBanners.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvBanners.adapter = bannerAdapter
            rvBanners.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        notifyPositionChanged(recyclerView)
                    }
                }
            })

            addDots(this.dots, bannerAdapter.items.size, 0)

            filters.forEach { filterItem ->
                this.chipGroupFilter.addView(filterItem.toChip(requireContext()))
            }
        }
    }

    private var position: Int? = RecyclerView.NO_POSITION
    private val snapHelper = LinearSnapHelper()

    private fun notifyPositionChanged(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position = if (view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)
        val positionChanged = this.position != position
        if (positionChanged) {
            addDots(binding.dots, bannerAdapter.items.size, position ?: 0)
        }
        this.position = position
    }

    private fun addDots(container: LinearLayout, size: Int, position: Int) {
        container.removeAllViews()
        Array(size) {
            val textView = TextView(context).apply {
                text = getString(R.string.dotted)
                textSize = 25f
                setTextColor(
                    if (position == it) ContextCompat.getColor(context, android.R.color.black)
                    else ContextCompat.getColor(context, android.R.color.darker_gray)
                )
            }
            container.addView(textView)
        }
    }
}