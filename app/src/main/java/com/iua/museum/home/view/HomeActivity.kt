package com.iua.museum.home.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.iua.museum.R
import com.iua.museum.databinding.ActivityHomeBinding
import com.iua.museum.item_detail.view.ItemDetailActivity
import com.iua.museum.item_detail.view.ItemDetailViewInput
import com.iua.museum.util.clearQR

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Hubo un error, intente de nuevo", Toast.LENGTH_SHORT).show()
            } else {
                result.contents?.let { content ->
                    val intent = Intent(this, ItemDetailActivity::class.java)
                    intent.putExtra(ItemDetailActivity.INPUT_VIEW_DATA_ITEM_DETAIL_KEY, ItemDetailViewInput(content.clearQR()))
                    startActivity(intent)
                } ?: run {
                    Toast.makeText(this, "Hubo un error, intente de nuevo", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}