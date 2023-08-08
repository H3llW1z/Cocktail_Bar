package com.panassevich.cocktailbar.domain.repository

import com.panassevich.cocktailbar.domain.entity.Cocktail

interface CocktailRepository {

    fun getAllCocktails(): List<Cocktail>

    fun addNewCocktail(cocktail: Cocktail)

    fun getCocktailById(id: Int): Cocktail
}