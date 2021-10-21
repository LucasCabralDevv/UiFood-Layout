package com.lucascabral.uifood.extensions

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.lucascabral.uifood.R
import com.lucascabral.uifood.model.FilterItem

fun FilterItem.toChip(context: Context): Chip {
    val chip = if (closeIcon == null) {
        LayoutInflater.from(context).inflate(R.layout.chip_choice, null, false) as Chip
    } else {
        Chip(ContextThemeWrapper(context, R.style.Widget_MaterialComponents_Chip_Choice))
    }

    if (closeIcon != null)
        chip.setChipBackgroundColorResource(R.color.white)

    chip.setChipStrokeColorResource(R.color.lt_gray)
    chip.chipStrokeWidth = 2f

    if (icon != null) {
        chip.chipIconSize = iconSize
        chip.setChipIconResource(icon)
        chip.chipStartPadding = 20f
    } else {
        chip.chipIcon = null
    }

    closeIcon?.let {
        chip.setCloseIconResource(it)
        chip.isCloseIconVisible = true
    }

    chip.text = this.text
    return chip
}