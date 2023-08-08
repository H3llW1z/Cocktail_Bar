package com.panassevich.cocktailbar

import android.app.Application
import com.panassevich.cocktailbar.di.ApplicationComponent
import com.panassevich.cocktailbar.di.DaggerApplicationComponent

class CocktailApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}