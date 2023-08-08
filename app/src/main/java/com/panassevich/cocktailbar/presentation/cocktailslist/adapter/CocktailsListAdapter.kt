package com.panassevich.cocktailbar.presentation.cocktailslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.panassevich.cocktailbar.databinding.CocktailListItemBinding
import com.panassevich.cocktailbar.domain.entity.Cocktail

class CocktailsListAdapter :
    ListAdapter<Cocktail, CocktailItemViewHolder>(CocktailItemDiffCallback()) {

    var onItemClick: ((Cocktail) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailItemViewHolder {
        val binding =
            CocktailListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CocktailItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CocktailItemViewHolder, position: Int) {
        val cocktail = currentList[position]
        with(holder.binding) {
            textViewCocktailTitle.text = cocktail.name
            onItemClick?.let { listener ->
                root.setOnClickListener { listener(cocktail) }
            }

        }
    }
}