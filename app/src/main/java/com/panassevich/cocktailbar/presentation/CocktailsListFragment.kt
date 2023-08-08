package com.panassevich.cocktailbar.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.panassevich.cocktailbar.R


class CocktailsListFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = CocktailsListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cocktails_list, container, false)
    }
}