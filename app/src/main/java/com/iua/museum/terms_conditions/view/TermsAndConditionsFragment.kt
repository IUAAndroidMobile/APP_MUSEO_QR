package com.iua.museum.terms_conditions.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iua.museum.HomeActivity
import com.iua.museum.databinding.FragmentTermsAndConditionsBinding
import com.iua.museum.terms_conditions.viewModel.TermsAndConditionsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TermsAndConditionsFragment: Fragment() {

    private val termsAndConditionsViewModel: TermsAndConditionsViewModel by viewModel()

    private var _binding: FragmentTermsAndConditionsBinding ? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTermsAndConditionsBinding.inflate(inflater, container, false)

        binding.tYCAcceptCheckBox.setOnCheckedChangeListener { _, isChecked ->
            termsAndConditionsViewModel.signTermsAndConditions(isChecked)
        }

        binding.btnContinue.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java))
            activity?.finish()
        }

        termsAndConditionsViewModel.bindingDelegate.setTermsAndConditionsSigned.observe(viewLifecycleOwner, ::onTermsAndConditionsSigned)

        return binding.root
    }

    private fun onTermsAndConditionsSigned(termsAndConditionsSigned: Boolean?) {
        termsAndConditionsSigned?.let {
            binding.btnContinue.isEnabled = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}