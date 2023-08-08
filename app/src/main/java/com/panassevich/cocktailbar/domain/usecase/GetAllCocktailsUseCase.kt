package com.panassevich.cocktailbar.domain.usecase

import com.panassevich.cocktailbar.domain.repository.CocktailRepository

class GetAllCocktailsUseCase(private val repository: CocktailRepository) {

    operator fun invoke() =
        repository.getAllCocktails()
}