package com.panassevich.cocktailbar.presentation.newcocktail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.panassevich.cocktailbar.databinding.AddIngredientButtonBinding
import com.panassevich.cocktailbar.databinding.IngredientListItemBinding

class IngredientsListAdapter :
    ListAdapter<IngredientItem, ViewHolder>(IngredientItemDiffCallback()) {

    var onIngredientClick: ((IngredientItem) -> Unit)? = null
    var onAddButtonClick: (() -> Unit)? = null

    companion object {
        const val TYPE_INGREDIENT = 1
        const val TYPE_ADD_BUTTON = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            TYPE_INGREDIENT -> {
                val binding = IngredientListItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return IngredientItemViewHolder(binding)
            }

            TYPE_ADD_BUTTON -> {
                val binding = AddIngredientButtonBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return AddButtonItemViewHolder(binding)
            }

            else -> throw IllegalStateException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_INGREDIENT -> {
                val ingredient = currentList[position]
                with((holder as IngredientItemViewHolder).binding) {
                    textViewContent.text = ingredient.description
                    root.setOnClickListener { onIngredientClick?.invoke(ingredient) }
                }
            }

            TYPE_ADD_BUTTON -> {
                (holder as AddButtonItemViewHolder).binding.imageViewAddButton.setOnClickListener {
                    onAddButtonClick?.invoke()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == currentList.size) {
            TYPE_ADD_BUTTON
        } else TYPE_INGREDIENT
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }
}