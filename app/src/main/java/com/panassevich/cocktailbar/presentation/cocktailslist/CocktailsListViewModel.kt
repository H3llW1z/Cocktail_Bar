package com.panassevich.cocktailbar.presentation.cocktailslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panassevich.cocktailbar.domain.usecase.GetAllCocktailsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CocktailsListViewModel @Inject constructor(
    private val getAllCocktailsUseCase: GetAllCocktailsUseCase
) : ViewModel() {

    private val _state: MutableLiveData<CocktailsListState> =
        MutableLiveData(CocktailsListState.Initial)
    val state: LiveData<CocktailsListState> = _state

    fun getAllCocktails() {
        viewModelScope.launch {
            val cocktails = getAllCocktailsUseCase()
            _state.value = when (cocktails.isEmpty()) {
                true -> CocktailsListState.EmptyList
                false -> CocktailsListState.Content(cocktails)
            }
        }

    }
}