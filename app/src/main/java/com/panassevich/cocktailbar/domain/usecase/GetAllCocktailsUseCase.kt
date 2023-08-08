package com.panassevich.cocktailbar.domain.usecase

import com.panassevich.cocktailbar.domain.repository.CocktailRepository

class GetAllCocktailsUseCase(private val repository: CocktailRepository) {

    suspend operator fun invoke() =
        repository.getAllCocktails()
}