package com.tecno_moviles.museo_cano_pacha.resultado_qr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tecno_moviles.museo_cano_pacha.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}