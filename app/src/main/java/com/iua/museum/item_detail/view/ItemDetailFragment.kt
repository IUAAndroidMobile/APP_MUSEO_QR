package com.iua.museum.item_detail.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.iua.museum.base.BaseFragment
import com.iua.museum.base.BaseViewModel
import com.iua.museum.base.viewModel.observe
import com.iua.museum.databinding.FragmentItemDetailBinding
import com.iua.museum.item_detail.usecase.ItemDetailUseCaseModel
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailFragment: BaseFragment() {

    private val itemDetailViewModel: ItemDetailViewModel by viewModel()
    private val viewInputArguments: ItemDetailFragmentArgs by navArgs()

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

        //observe(itemDetailViewModel.bindingDelegate.setItemDetail, this::onItemDetailReceived)
        itemDetailViewModel.bindingDelegate.setItemDetail.observe(viewLifecycleOwner, ::onItemDetailReceived)

        callGetItemDetailData()
    }

    private fun onItemDetailReceived(item: ItemDetailUseCaseModel) {
        binding?.let { view ->
            view.itemCollapsingTitle.title = item.title
            view.itemToolbar.title = item.title
            view.itemDescriptionTextView.text = item.description

        }
    }

    private fun callGetItemDetailData() {
        viewInputArguments.itemDetailViewInputData?.let { itemDetailViewInput ->
            Log.d("ITEM_DETAIL_VIEW_INPUT_DATA", "ID: ${itemDetailViewInput.publicId} ")
             itemDetailViewModel.callGetItemById(itemDetailViewInput.publicId)
        }
    }
}