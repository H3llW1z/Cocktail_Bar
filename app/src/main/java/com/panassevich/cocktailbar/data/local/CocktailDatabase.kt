package com.panassevich.cocktailbar.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.panassevich.cocktailbar.data.local.model.CocktailDbModel
import com.panassevich.cocktailbar.data.local.model.IngredientDbModel

@Database(
    entities = [CocktailDbModel::class, IngredientDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class CocktailDatabase : RoomDatabase() {

    abstract fun cocktailsDao(): CocktailsDao

    abstract fun ingredientsDao(): IngredientsDao

    companion object {
        private var INSTANCE: CocktailDatabase? = null
        private const val DATABASE_NAME = "main.db"

        fun getInstance(application: Application): CocktailDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    application,
                    CocktailDatabase::class.java,
                    DATABASE_NAME
                ).build().also { INSTANCE = it }
            }
    }
}