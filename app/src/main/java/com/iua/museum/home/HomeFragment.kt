package com.iua.museum.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.zxing.integration.android.IntentIntegrator
import com.iua.museum.base.BaseFragment
import com.iua.museum.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScan.setOnClickListener {
            IntentIntegrator(activity).initiateScan()
        }

        binding.btnSeeContent.setOnClickListener {
            Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavHomeToItemsListFragment())
        }

        binding.helpIcon.setOnClickListener {
            Navigation.findNavController(view).navigate(HomeFragmentDirections.actionNavHomeToHelpFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}