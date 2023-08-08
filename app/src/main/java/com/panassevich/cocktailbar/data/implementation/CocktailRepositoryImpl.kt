package com.panassevich.cocktailbar.data.implementation

import com.panassevich.cocktailbar.data.local.CocktailsDao
import com.panassevich.cocktailbar.data.local.IngredientsDao
import com.panassevich.cocktailbar.data.local.model.IngredientDbModel
import com.panassevich.cocktailbar.data.toDbModel
import com.panassevich.cocktailbar.data.toEntity
import com.panassevich.cocktailbar.domain.entity.Cocktail
import com.panassevich.cocktailbar.domain.repository.CocktailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailsDao: CocktailsDao,
    private val ingredientsDao: IngredientsDao
) : CocktailRepository {
//    override suspend fun getAllCocktails(): List<Cocktail> = withContext(Dispatchers.IO) {
//        val cocktailDbModels = cocktailsDao.getAllCocktails()
//        cocktailDbModels.map { cocktail ->
//            val ingredients =
//                ingredientsDao.getIngredientsByCocktailId(cocktail.id).map { it.description }
//            cocktail.toEntity(ingredients)
//        }
//    }

    override suspend fun getAllCocktails(): List<Cocktail> {
        val list = mutableListOf<Cocktail>()
        repeat(10) {
            list.add(Cocktail(it.toLong(), "Cocktail $it", listOf("a", "a"), null, null))
        }
        return list
    }

    override suspend fun addNewCocktail(cocktail: Cocktail) = withContext(Dispatchers.IO) {
        val cocktailId = cocktailsDao.insertNewCocktail(cocktail.toDbModel())
        val ingredients = cocktail.ingredients.map { description ->
            IngredientDbModel(
                cocktailId = cocktailId,
                description = description
            )
        }
        ingredientsDao.insertIngredients(ingredients)
    }

    override suspend fun getCocktailById(id: Long): Cocktail = withContext(Dispatchers.IO) {
        val cocktailDbModel = cocktailsDao.getCocktailById(id)
        val ingredients = ingredientsDao.getIngredientsByCocktailId(cocktailDbModel.id)
            .map { it.description }
        return@withContext cocktailDbModel.toEntity(ingredients)
    }
}