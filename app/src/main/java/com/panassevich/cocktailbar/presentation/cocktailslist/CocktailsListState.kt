package com.panassevich.cocktailbar.presentation.cocktailslist

import com.panassevich.cocktailbar.domain.entity.Cocktail

sealed class CocktailsListState {
    data object Initial : CocktailsListState()
    data class Content(val data: List<Cocktail>) : CocktailsListState()

    data object EmptyList : CocktailsListState()
}
