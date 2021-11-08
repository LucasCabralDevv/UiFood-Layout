package com.lucascabral.uifood

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.lucascabral.uifood.databinding.BannerItemBinding
import com.lucascabral.uifood.databinding.CategoryItemBinding
import com.lucascabral.uifood.model.Banner
import com.squareup.picasso.Picasso

class BannerView(viewGroup: ViewGroup) : ATViewHolder<Banner, BannerItemBinding>(
    BannerItemBinding::inflate,
    viewGroup
) {
    override fun bind(item: Banner) {
        Picasso.get().load(item.bannerUrl).into(binding.imgBanner)
    }

}