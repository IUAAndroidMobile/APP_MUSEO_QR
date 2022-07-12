package com.iua.museum.splash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iua.museum.base.BaseFragment
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.databinding.FragmentSplashBinding
import com.iua.museum.splash.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment() {

    private val splashViewModel: SplashViewModel by viewModel()

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun getViewModel(): BaseViewModel = splashViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

}