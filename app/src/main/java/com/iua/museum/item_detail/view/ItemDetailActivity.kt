package com.iua.museum.item_detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.iua.museum.R
import com.iua.museum.databinding.ActivityItemDetailBinding
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel

class ItemDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailBinding

    private lateinit var viewModel: ItemDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)

        //Check input params
        if (intent.extras?.containsKey(INPUT_VIEW_DATA_ITEM_DETAIL_KEY) == true) {
            val inputParams = intent.getParcelableExtra<ItemDetailViewInput>(INPUT_VIEW_DATA_ITEM_DETAIL_KEY)
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_item_detail) as NavHostFragment
            val graph = navHostFragment.navController.navInflater.inflate(R.navigation.item_detail_navigation)
            navHostFragment.navController.setGraph(graph, Bundle().apply { putParcelable("itemDetailViewInputData", inputParams) })
        }
        setContentView(binding.root)
    }

    companion object {
        const val INPUT_VIEW_DATA_ITEM_DETAIL_KEY = "inputViewDataItemDetailKey"
    }
}