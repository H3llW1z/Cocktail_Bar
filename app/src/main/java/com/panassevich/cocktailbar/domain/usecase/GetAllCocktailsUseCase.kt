package com.panassevich.cocktailbar.domain.usecase

import com.panassevich.cocktailbar.domain.repository.CocktailRepository
import javax.inject.Inject

class GetAllCocktailsUseCase @Inject constructor(private val repository: CocktailRepository) {

    suspend operator fun invoke() =
        repository.getAllCocktails()
}