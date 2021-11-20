package com.example.notalone.test

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notalone.MainActivity
import com.example.notalone.R
import com.example.notalone.common.Test
import com.example.notalone.adapter.MessageAdapter
import com.example.notalone.databinding.FragmentTestBinding
import com.example.notalone.entity.Message
import kotlinx.coroutines.*

class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding

    private var messagesList = mutableListOf<Message>()
    private lateinit var adapter: MessageAdapter
    private var pos = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MessageAdapter()
        binding.rvMessages.adapter = adapter
        binding.rvMessages.layoutManager = LinearLayoutManager(this.requireContext())

        binding.btnYes.setOnClickListener {
            val message = binding.btnYes.text.toString()
            if (message.isNotEmpty()) {
                if (pos > 8) {
                    startActivity(Intent(this.requireContext(), MainActivity::class.java))
                }
                messagesList.add(Message(message, SEND_ID))

                adapter.insertMessage(Message(message, SEND_ID))
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

                botResponse(message, pos)
                pos++
            }
        }
        binding.btnNo.setOnClickListener {
            val message = binding.btnNo.text.toString()
            if (pos > 8) {
                startActivity(Intent(this.requireContext(), MainActivity::class.java))
            }
            if (message.isNotEmpty()) {
                messagesList.add(Message(message, SEND_ID))

                adapter.insertMessage(Message(message, SEND_ID))
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

                botResponse(message, pos)
                pos++
            }
        }

        customBotMessage(getString(R.string.test_mes_bot))
    }

    private fun botResponse(message: String, position: Int) {
        GlobalScope.launch {
            delay(500)
            withContext(Dispatchers.Main) {
                val response = Test.getTestAnswer(message, position)
                messagesList.add(Message(response, RECEIVE_ID))
                adapter.insertMessage(Message(response, RECEIVE_ID))
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun customBotMessage(message: String) {
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                messagesList.add(Message(message, RECEIVE_ID))
                adapter.insertMessage(Message(message, RECEIVE_ID))

                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    companion object {
        private const val RECEIVE_ID = "RECEIVE_ID"
        private const val SEND_ID = "SEND_ID"
    }
}