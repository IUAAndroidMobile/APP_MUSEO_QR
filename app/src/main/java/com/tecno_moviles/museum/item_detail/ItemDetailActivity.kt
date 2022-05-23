package com.tecno_moviles.museum.item_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tecno_moviles.museum.databinding.ActivityItemDetailBinding

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