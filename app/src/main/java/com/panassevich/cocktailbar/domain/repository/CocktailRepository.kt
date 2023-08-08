package com.panassevich.cocktailbar.domain.repository

import com.panassevich.cocktailbar.domain.entity.Cocktail

interface CocktailRepository {

    suspend fun getAllCocktails(): List<Cocktail>

    suspend fun addNewCocktail(cocktail: Cocktail)

    suspend fun getCocktailById(id: Long): Cocktail
}