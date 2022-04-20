package com.tecno_moviles.museo_cano_pacha.ui.ayuda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tecno_moviles.museo_cano_pacha.databinding.FragmentAyudaBinding

class AyudaFragment : Fragment() {

    private lateinit var ayudaViewModel: AyudaViewModel
    private var _binding: FragmentAyudaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ayudaViewModel =
            ViewModelProvider(this).get(AyudaViewModel::class.java)

        _binding = FragmentAyudaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMail.setOnClickListener {
            enviarMail()
        }
    }

    fun enviarMail() {
        val intent = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts("mailto", "pacha.eli.2021@gmail.com", null)
        )
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(activity?.applicationContext , e.message, Toast.LENGTH_LONG).show ()
        }

        Toast.makeText(activity?.applicationContext,"Enviando mail", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}