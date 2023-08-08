package com.panassevich.cocktailbar.data

import com.panassevich.cocktailbar.data.local.model.CocktailDbModel
import com.panassevich.cocktailbar.domain.entity.Cocktail

fun Cocktail.toDbModel() = CocktailDbModel(
    id = id,
    name = name,
    description = description,
    recipe = recipe
)

fun CocktailDbModel.toEntity(ingredients: List<String>) = Cocktail(
    id = id,
    name = name,
    ingredients = ingredients,
    description = description,
    recipe = recipe
)
