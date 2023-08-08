package com.panassevich.cocktailbar.di

import android.app.Application
import com.panassevich.cocktailbar.di.annotation.ApplicationScope
import com.panassevich.cocktailbar.di.module.DataModule
import com.panassevich.cocktailbar.di.module.ViewModelModule
import com.panassevich.cocktailbar.presentation.cocktailslist.CocktailsListFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    fun inject(fragment: CocktailsListFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}