package com.panassevich.cocktailbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panassevich.cocktailbar.presentation.cocktailslist.CocktailsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_fragment_container, CocktailsListFragment.newInstance(), null)
                .commit()
        }
    }
}