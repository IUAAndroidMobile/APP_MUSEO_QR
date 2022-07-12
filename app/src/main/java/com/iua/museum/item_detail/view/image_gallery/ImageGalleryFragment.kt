package com.iua.museum.item_detail.view.image_gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.iua.museum.R
import com.iua.museum.base.BaseFragment
import com.iua.museum.base.viewModel.BaseViewModel
import com.iua.museum.databinding.FragmentImageGalleryBinding
import com.iua.museum.item_detail.usecase.ImageGalleryItem
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

//https://developer.android.com/guide/navigation/navigation-swipe-view-2?hl=es-419

class ImageGalleryFragment: BaseFragment() {

    //Shared ViewModel between two fragments.
    private val itemDetailViewModel: ItemDetailViewModel by viewModel()
    private val viewInputArguments: ImageGalleryFragmentArgs by navArgs()

    private lateinit var imageGalleryCollectionAdapter: ImageGalleryCollectionAdapter
    private lateinit var viewPager: ViewPager2

    private var binding: FragmentImageGalleryBinding? = null

    override fun getViewModel(): BaseViewModel = itemDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentImageGalleryBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageGalleryCollectionAdapter = ImageGalleryCollectionAdapter(this, getImageGalleryArgument())
        viewPager = binding?.pagerGalleryImage!!
        viewPager.adapter = imageGalleryCollectionAdapter
    }

    private fun getImageGalleryArgument(): List<ImageGalleryItem>? {
        viewInputArguments.itemDetailImageGalleryViewInput?.let { imageGalleryViewInput ->
            return imageGalleryViewInput.imageList
        }
        return null
    }
}

class ImageGalleryCollectionAdapter(fragment: Fragment, val dataList : List<ImageGalleryItem>?): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = dataList?.size ?: 0

    override fun createFragment(position: Int): Fragment {
        val fragment = ItemImageFragment()
        fragment.arguments = Bundle().apply {
            putParcelable(ARG_OBJECT, dataList?.get(position))
        }
        return fragment
    }

}

private const val ARG_OBJECT = "imageItemGalleryArgument"

class ItemImageFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val imageItem = this.get(ARG_OBJECT) as ImageGalleryItem
           val textView: TextView = view.findViewById(R.id.image_description)
            Glide.with(view)
                .load(imageItem.imageURL)
                .into(view.findViewById(R.id.image_item_detail))
            textView.text = imageItem.imageDescription
        }
    }
}