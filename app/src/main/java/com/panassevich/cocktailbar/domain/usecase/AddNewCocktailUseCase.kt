package com.panassevich.cocktailbar.domain.usecase

import com.panassevich.cocktailbar.domain.entity.Cocktail
import com.panassevich.cocktailbar.domain.repository.CocktailRepository

class AddNewCocktailUseCase(private val repository: CocktailRepository) {

    suspend operator fun invoke(cocktail: Cocktail) =
        repository.addNewCocktail(cocktail)
}