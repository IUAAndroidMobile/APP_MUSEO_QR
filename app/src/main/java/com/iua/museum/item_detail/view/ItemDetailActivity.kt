package com.iua.museum.item_detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.museum.databinding.ActivityItemDetailBinding
import com.iua.museum.item_detail.viewModel.ItemDetailViewModel

class ItemDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailBinding

    private lateinit var viewModel: ItemDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO: We should inject the view model.
        //viewModel = ViewModelProvider(this).get(ItemDetailViewModel::class.java)
    }
}