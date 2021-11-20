package com.example.notalone

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notalone.adapter.MessageAdapter
import com.example.notalone.common.BotResponse
import com.example.notalone.databinding.FragmentBotBinding
import com.example.notalone.entity.Message
import kotlinx.coroutines.*

class BotFragment : Fragment() {

    private lateinit var binding: FragmentBotBinding
    private var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MessageAdapter()
        binding.rvMessages.adapter = adapter
        binding.rvMessages.layoutManager = LinearLayoutManager(this.requireContext())

        binding.btnSend.setOnClickListener {
            val message = binding.enterMessage.text.toString()

            if (message.isNotEmpty()) {
                messagesList.add(Message(message, SEND_ID))
                binding.enterMessage.setText("")

                adapter.insertMessage(Message(message, SEND_ID))
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

                botResponse(message)
            }
        }
        binding.enterMessage.setOnClickListener {
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main) {
                    binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
        customBotMessage(getString(R.string.first_mes_bot))
    }

    private fun botResponse(message: String) {
        GlobalScope.launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                val response = BotResponse.getBasicResponses(message)
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