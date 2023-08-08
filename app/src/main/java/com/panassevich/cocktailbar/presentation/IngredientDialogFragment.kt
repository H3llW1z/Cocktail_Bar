package com.panassevich.cocktailbar.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.panassevich.cocktailbar.databinding.AddIngredientDialogBinding

class IngredientDialogFragment : DialogFragment() {

    private var _binding: AddIngredientDialogBinding? = null
    private val binding: AddIngredientDialogBinding
        get() = _binding ?: throw RuntimeException("AddIngredientDialogBinding is null")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            _binding = AddIngredientDialogBinding.inflate(LayoutInflater.from(context))

            AlertDialog.Builder(it)
                .setView(binding.root)
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun prepareButtons() {
        binding.buttonCloseDialog.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}