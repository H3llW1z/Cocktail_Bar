package com.panassevich.cocktailbar.domain.usecase

import com.panassevich.cocktailbar.domain.repository.CocktailRepository

class GetCocktailByIdUseCase(private val repository: CocktailRepository) {

    operator fun invoke(id: Int) = repository.getCocktailById(id)
}