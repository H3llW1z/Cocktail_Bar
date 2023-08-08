package com.panassevich.cocktailbar.presentation.cocktailslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.panassevich.cocktailbar.CocktailApplication
import com.panassevich.cocktailbar.R
import com.panassevich.cocktailbar.databinding.FragmentCocktailsListBinding
import com.panassevich.cocktailbar.di.ViewModelFactory
import com.panassevich.cocktailbar.presentation.cocktailslist.adapter.CocktailsListAdapter
import com.panassevich.cocktailbar.presentation.newcocktail.NewCocktailFragment
import javax.inject.Inject


class CocktailsListFragment : Fragment() {

    private var _binding: FragmentCocktailsListBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentCocktailsListBinding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: CocktailsListViewModel

    private val cocktailsListAdapter = CocktailsListAdapter()

    companion object {

        @JvmStatic
        fun newInstance() = CocktailsListFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as CocktailApplication).component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[CocktailsListViewModel::class.java]
        prepareRecyclerView()
        prepareNewCocktailButton()
        observeState()
        viewModel.getAllCocktails()
    }

    private fun prepareRecyclerView() {
        cocktailsListAdapter.onItemClick = { cocktail ->
            Toast.makeText(
                requireContext(),
                "Клик на коктейль с id ${cocktail.id}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.recyclerViewCocktails.adapter = cocktailsListAdapter
    }

    private fun prepareNewCocktailButton() {
        binding.fabNewCocktail.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, NewCocktailFragment.newInstance(), null)
                .addToBackStack(NewCocktailFragment.TAG)
                .commit()
        }
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is CocktailsListState.Initial -> {}
                is CocktailsListState.EmptyList -> {
                    setEmptyListViewsVisibility(View.VISIBLE)
                    with(binding) {
                        textViewTitle.visibility = View.GONE
                    }
                }

                is CocktailsListState.Content -> {
                    setEmptyListViewsVisibility(View.GONE)
                    with(binding) {
                        textViewTitle.visibility = View.VISIBLE
                    }
                    cocktailsListAdapter.submitList(state.data)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setEmptyListViewsVisibility(visibility: Int) {
        with(binding) {
            imageViewNoCocktails.visibility = visibility
            textViewNoCocktails.visibility = visibility
            imageViewArrow.visibility = visibility
            textViewHint.visibility = visibility
        }
    }
}