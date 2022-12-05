package com.iua.museum.item_detail.view

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.iua.museum.R
import com.iua.museum.base.BaseFragment
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.base.toVisible
import com.iua.museum.databinding.FragmentItemDetailBinding
import com.iua.museum.item_detail.usecase.ItemDetailUseCaseModel
import com.iua.museum.item_detail.view.image_gallery.ImageGalleryViewInput
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ItemDetailFragment : BaseFragment(), TextToSpeech.OnInitListener {

    private val itemDetailViewModel: ItemDetailViewModel by viewModel()
    private val viewInputArguments: ItemDetailFragmentArgs by navArgs()

    private var binding: FragmentItemDetailBinding? = null

    private var tts: TextToSpeech? = null

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

        tts = TextToSpeech(requireContext(), this)

        callGetItemDetailData()
    }

    private fun onItemDetailReceived(item: ItemDetailUseCaseModel) {
        binding?.let { view ->
            Glide.with(requireContext())
                .load(item.imageGallery.first().imageURL)
                .into(view.mainImage)

            view.mainImage.setOnClickListener {
                val imageGallery = ImageGalleryViewInput(item.imageGallery)
                val action = ItemDetailFragmentDirections.actionItemDetailFragmentToImageGalleryFragment()
                action.itemDetailImageGalleryViewInput = imageGallery
                Navigation.findNavController(it).navigate(action)
            }

            view.itemCollapsingTitle.title = item.title
            view.itemToolbar.title = item.title
            view.itemIntroductionTextView.text = item.introduction
            view.itemDescriptionTextView.text = item.description

            if (item.youToubeLinks.isNotEmpty()) {
                val videoView = view.youtubeLinksTextView
                videoView.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.youToubeLinks.first())))
                }
            }

            if (item.externalLinks.isNotEmpty()) {
                view.externalLinks.text = item.externalLinks.first()
                view.externalLinks.toVisible()
                view.externalLinks.paintFlags = Paint.UNDERLINE_TEXT_FLAG
                view.externalLinks.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.externalLinks.first())))
                }
            }

            view.reproduceTextButton.setOnClickListener {
                tts?.let { tts ->
                    if (tts.isSpeaking) {
                        tts.stop()
                        view.reproduceTextButton.text = getString(R.string.item_detail_play_sound)
                        view.reproduceTextButton.setCompoundDrawablesWithIntrinsicBounds(
                            AppCompatResources.getDrawable(
                                requireContext(),
                                R.drawable.ic_play_video_circle
                            ),
                            null,
                            null,
                            null
                        )
                    } else {
                        tts.speak(
                            item.title + "." + item.introduction + item.description,
                            TextToSpeech.QUEUE_FLUSH,
                            null,
                            null
                        )
                        view.reproduceTextButton.text = getString(R.string.item_detail_stop_sound)
                        view.reproduceTextButton.setCompoundDrawablesWithIntrinsicBounds(
                            AppCompatResources.getDrawable(
                                requireContext(),
                                R.drawable.ic_stop_circle
                            ),
                            null,
                            null,
                            null
                        )
                    }
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

    override fun onPause() {
        super.onPause()
        tts?.stop()
    }

    override fun onInit(p0: Int) {
        tts?.language = Locale.getDefault()
    }
}