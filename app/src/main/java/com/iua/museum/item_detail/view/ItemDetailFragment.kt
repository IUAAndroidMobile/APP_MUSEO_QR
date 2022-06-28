package com.iua.museum.item_detail.view

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.iua.museum.base.BaseFragment
import com.iua.museum.base.BaseViewModel
import com.iua.museum.base.toVisible
import com.iua.museum.databinding.FragmentItemDetailBinding
import com.iua.museum.item_detail.usecase.ItemDetailUseCaseModel
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailFragment : BaseFragment() {

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

        itemDetailViewModel.bindingDelegate.setItemDetail.observe(
            viewLifecycleOwner,
            ::onItemDetailReceived
        )

        callGetItemDetailData()
    }

    private fun onItemDetailReceived(item: ItemDetailUseCaseModel) {
        binding?.let { view ->
            context?.let {
                Glide.with(it)
                    .load(item.imageGallery.first().imageURL)
                    .into(view.image)
            }
            view.itemCollapsingTitle.title = item.title
            view.itemToolbar.title = item.title
            view.itemIntroductionTextView.text = item.introduction
            view.itemDescriptionTextView.text = item.description

            if (item.youToubeLinks.isNotEmpty()) {
                val videoView = view.youtubeLinksTextView
                videoView.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.youToubeLinks)))
                }
            }

            if (item.externalLinks.isNotEmpty()) {
                view.externalLinks.text = item.externalLinks
                view.externalLinks.toVisible()
                view.externalLinks.paintFlags = Paint.UNDERLINE_TEXT_FLAG
                view.externalLinks.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.externalLinks)))
                }
            }


        }
    }

    private fun callGetItemDetailData() {
        viewInputArguments.itemDetailViewInputData?.let { itemDetailViewInput ->
            Log.d("ITEM_DETAIL_VIEW_INPUT_DATA", "ID: ${itemDetailViewInput.publicId} ")
            itemDetailViewModel.callGetItemById(itemDetailViewInput.publicId)
        }
    }
}