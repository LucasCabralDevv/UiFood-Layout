package com.lucascabral.uifood

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabViewPagerAdapter(
    fragment: FragmentActivity
) : FragmentStateAdapter(fragment) {

    val tabs = arrayListOf(R.string.restaurants, R.string.marketplaces, R.string.drinks)
    private val fragments = arrayListOf(MarketplaceFragment(), MarketplaceFragment(), MarketplaceFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}