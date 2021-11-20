package com.example.notalone.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.notalone.R
import com.example.notalone.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            if (binding.editName.text.isNullOrEmpty()) {
                binding.inputName.error = "Enter name"
            }
            if (binding.editBirth.text.isNullOrEmpty()) {
                binding.inputBirth.error = "Enter date"
            } else {
                findNavController().navigate(R.id.action_nameFragment_to_testFragment)
            }
        }
    }
}