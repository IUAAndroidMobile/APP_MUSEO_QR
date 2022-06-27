package com.iua.museum.terms_conditions.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.iua.museum.home.view.HomeActivity
import com.iua.museum.R
import com.iua.museum.databinding.FragmentTermsAndConditionsBinding
import com.iua.museum.splash.view.SplashActivity
import com.iua.museum.terms_conditions.viewModel.TermsAndConditionsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TermsAndConditionsFragment: Fragment() {

    private val termsAndConditionsViewModel: TermsAndConditionsViewModel by viewModel()

    private var _binding: FragmentTermsAndConditionsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTermsAndConditionsBinding.inflate(inflater, container, false)

        binding.tYCAcceptCheckBox.setOnCheckedChangeListener { _, checked ->
            binding.btnContinue.isEnabled = checked
        }

        binding.btnContinue.setOnClickListener {
            termsAndConditionsViewModel.signTermsAndConditions(true)
            termsAndConditionsViewModel.isNewUser()
        }

        termsAndConditionsViewModel.bindingDelegate.setTermsAndConditionsSigned.observe(viewLifecycleOwner, ::onTermsAndConditionsSigned)
        termsAndConditionsViewModel.bindingDelegate.setIsNewUser.observe(viewLifecycleOwner, ::onIsNewUser)

        return binding.root
    }

    private fun onIsNewUser(isNewUser: Boolean?) {
        isNewUser?.let { newUser ->
            if (newUser) {
                Navigation.findNavController(activity as SplashActivity, R.id.nav_host_fragment_splash).navigate(TermsAndConditionsFragmentDirections.actionTermsAndConditionsFragmentToHelpFragment())
                termsAndConditionsViewModel.saveIsNewUser()
            } else {
                startActivity(Intent(activity, HomeActivity::class.java))
                activity?.finish()
            }
        }
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