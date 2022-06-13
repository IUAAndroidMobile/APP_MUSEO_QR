package com.iua.museum.ui.conf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iua.museum.databinding.FragmentConfBinding

class ConfFragment : Fragment() {

    private lateinit var confViewModel: ConfViewModel
    private var _binding: FragmentConfBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        confViewModel =
            ViewModelProvider(this).get(ConfViewModel::class.java)

        _binding = FragmentConfBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.switch1.setOnClickListener {
            if (binding.switch1.isChecked) binding.switch1.isChecked = true else binding.switch1.isChecked = false
        }

        binding.edit1.setOnClickListener {
            binding.inputNombre.isEnabled = true
        }
        binding.edit2.setOnClickListener {
            binding.inputMail.isEnabled = true
        }
        binding.edit3.setOnClickListener {
            binding.inputPassword.isEnabled = true
        }

        binding.btnGuardarConf.setOnClickListener {
            binding.inputNombre.isEnabled = false
            binding.inputMail.isEnabled = false
            binding.inputPassword.isEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}