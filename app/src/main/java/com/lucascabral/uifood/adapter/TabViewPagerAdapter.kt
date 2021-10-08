package com.lucascabral.uifood.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lucascabral.uifood.R
import com.lucascabral.uifood.fragments.DrinksFragment
import com.lucascabral.uifood.fragments.MarketplaceFragment
import com.lucascabral.uifood.fragments.RestaurantsFragment

class TabViewPagerAdapter(
    fragment: FragmentActivity
) : FragmentStateAdapter(fragment) {

    val tabs = arrayListOf(R.string.restaurants, R.string.marketplaces, R.string.drinks)
    private val fragments = arrayListOf(RestaurantsFragment(), MarketplaceFragment(), DrinksFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}