package com.tecno_moviles.museo_cano_pacha.item_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tecno_moviles.museo_cano_pacha.base.BaseFragment
import com.tecno_moviles.museo_cano_pacha.databinding.FragmentHomeBinding
import com.tecno_moviles.museo_cano_pacha.databinding.FragmentItemDetailBinding

class ItemDetailFragment: BaseFragment() {

    private var binding: FragmentItemDetailBinding? = null

    private lateinit var viewModel: ItemDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}