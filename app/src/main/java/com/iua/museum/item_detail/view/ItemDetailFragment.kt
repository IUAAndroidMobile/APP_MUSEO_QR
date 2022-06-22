package com.iua.museum.item_detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iua.museum.base.BaseFragment
import com.iua.museum.base.BaseViewModel
import com.iua.museum.databinding.FragmentItemDetailBinding
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailFragment: BaseFragment() {

    private val itemDetailViewModel: ItemDetailViewModel by viewModel()

    private var binding: FragmentItemDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun getViewModel(): BaseViewModel = itemDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}