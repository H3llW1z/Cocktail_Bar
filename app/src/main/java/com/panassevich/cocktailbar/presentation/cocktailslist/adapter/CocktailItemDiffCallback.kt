package com.panassevich.cocktailbar.presentation.cocktailslist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.panassevich.cocktailbar.domain.entity.Cocktail

class CocktailItemDiffCallback : DiffUtil.ItemCallback<Cocktail>() {
    override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
        oldItem == newItem
}