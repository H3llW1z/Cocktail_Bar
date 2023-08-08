package com.panassevich.cocktailbar.di.module

import androidx.lifecycle.ViewModel
import com.panassevich.cocktailbar.di.annotation.ViewModelKey
import com.panassevich.cocktailbar.presentation.cocktailslist.CocktailsListViewModel
import com.panassevich.cocktailbar.presentation.newcocktail.NewCocktailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CocktailsListViewModel::class)
    fun bindCocktailsListViewModel(viewModel: CocktailsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewCocktailViewModel::class)
    fun bindNewCocktailViewModel(viewModel: NewCocktailViewModel): ViewModel

}