package com.panassevich.cocktailbar.domain.usecase

import com.panassevich.cocktailbar.domain.entity.Cocktail
import com.panassevich.cocktailbar.domain.repository.CocktailRepository
import javax.inject.Inject

class AddNewCocktailUseCase @Inject constructor(private val repository: CocktailRepository) {

    suspend operator fun invoke(cocktail: Cocktail) =
        repository.addNewCocktail(cocktail)
}