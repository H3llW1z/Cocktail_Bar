package com.panassevich.cocktailbar.di.module

import android.app.Application
import com.panassevich.cocktailbar.data.implementation.CocktailRepositoryImpl
import com.panassevich.cocktailbar.data.local.CocktailDatabase
import com.panassevich.cocktailbar.data.local.CocktailsDao
import com.panassevich.cocktailbar.data.local.IngredientsDao
import com.panassevich.cocktailbar.di.annotation.ApplicationScope
import com.panassevich.cocktailbar.domain.repository.CocktailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCocktailRepository(impl: CocktailRepositoryImpl): CocktailRepository

    companion object {

        @Provides
        fun provideCocktailsDao(application: Application): CocktailsDao =
            CocktailDatabase.getInstance(application).cocktailsDao()

        @Provides
        fun provideIngredientsDao(application: Application): IngredientsDao =
            CocktailDatabase.getInstance(application).ingredientsDao()
    }
}