package com.panassevich.cocktailbar.domain.usecase

import com.panassevich.cocktailbar.domain.repository.CocktailRepository

class GetCocktailByIdUseCase(private val repository: CocktailRepository) {

    suspend operator fun invoke(id: Long) = repository.getCocktailById(id)
}