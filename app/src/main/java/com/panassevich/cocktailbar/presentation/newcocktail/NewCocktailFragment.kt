package com.panassevich.cocktailbar.presentation.newcocktail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.panassevich.cocktailbar.CocktailApplication
import com.panassevich.cocktailbar.R
import com.panassevich.cocktailbar.databinding.FragmentNewCocktailBinding
import com.panassevich.cocktailbar.di.ViewModelFactory
import com.panassevich.cocktailbar.presentation.newcocktail.adapter.IngredientsListAdapter
import javax.inject.Inject

class NewCocktailFragment : Fragment() {

    private var _binding: FragmentNewCocktailBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentNewCocktailBinding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: NewCocktailViewModel

    private val ingredientsListAdapter = IngredientsListAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as CocktailApplication).component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewCocktailViewModel::class.java]

        prepareIngredientsRecyclerView()
        prepareButtons()
        observeState()
    }

    private fun prepareIngredientsRecyclerView() {
        ingredientsListAdapter.onIngredientClick = { item ->
            val newList = ingredientsListAdapter.currentList.toList().filter { it != item }
            ingredientsListAdapter.submitList(newList)
        }
        ingredientsListAdapter.onAddButtonClick = {
            showIngredientDialog()
        }
        with(binding.recyclerViewIngredients) {
            this.adapter = ingredientsListAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    }

    private fun prepareButtons() {
        with(binding) {
            buttonCancel.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
            buttonSave.setOnClickListener {
                val name = editTextCocktailName.text.toString().trim()
                val description = editTextDescription.text.toString().trim()
                val ingredients = ingredientsListAdapter.currentList.map { it.description }
                val recipe = editTextRecipe.text.toString().trim()

                viewModel.addNewCocktail(
                    name = name,
                    description = description,
                    ingredients = ingredients,
                    recipe = recipe
                )
            }
        }
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                NewCocktailScreenState.Initial -> {}
                is NewCocktailScreenState.InputError -> {
                    binding.editTextCocktailName.error =
                        if (state.missingName) getString(R.string.add_cocktail_name) else null

                    if (state.missingIngredients) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.add_ingredients), Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                is NewCocktailScreenState.AddedSuccessfully -> {
                    parentFragmentManager.popBackStack()
                }
            }
        }
    }

    private fun showIngredientDialog() {
        val dialogFragment = IngredientDialogFragment()
        dialogFragment.show(parentFragmentManager, null)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = NewCocktailFragment()

        const val TAG = "new_cocktail_fragment"
    }
}