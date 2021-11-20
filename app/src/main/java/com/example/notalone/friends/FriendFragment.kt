package com.example.notalone.friends

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notalone.databinding.FragmentFriendBinding

class FriendFragment : Fragment() {

    private lateinit var binding: FragmentFriendBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFriendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOpenChat.setOnClickListener {
            startActivity(Intent(this.requireContext(), DialogActivity::class.java))
        }
    }
}