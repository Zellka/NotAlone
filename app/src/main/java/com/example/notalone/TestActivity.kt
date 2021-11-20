package com.example.notalone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notalone.databinding.ActivityTestBinding
import kotlinx.coroutines.*

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding
    private var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MessageAdapter()
        binding.bot.rvMessages.adapter = adapter
        binding.bot.rvMessages.layoutManager = LinearLayoutManager(this)

        binding.bot.btnSend.setOnClickListener {
            val message = binding.bot.enterMessage.text.toString()

            if (message.isNotEmpty()) {
                if (message.toLowerCase() == "exit") {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                messagesList.add(Message(message, Companion.SEND_ID))
                binding.bot.enterMessage.setText("")

                adapter.insertMessage(Message(message, Companion.SEND_ID))
                binding.bot.rvMessages.scrollToPosition(adapter.itemCount - 1)

                botResponse(message)
            }
        }
        binding.bot.enterMessage.setOnClickListener {
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main) {
                    binding.bot.rvMessages.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
        customBotMessage(getString(R.string.test_mes_bot))
    }

    private fun botResponse(message: String) {
        GlobalScope.launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                val response = BotResponse.getBasicResponses(message)
                messagesList.add(Message(response, Companion.RECEIVE_ID))
                adapter.insertMessage(Message(response, Companion.RECEIVE_ID))
                binding.bot.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                binding.bot.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun customBotMessage(message: String) {
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                messagesList.add(Message(message, Companion.RECEIVE_ID))
                adapter.insertMessage(Message(message, Companion.RECEIVE_ID))

                binding.bot.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    companion object {
        private const val RECEIVE_ID = "RECEIVE_ID"
        private const val SEND_ID = "SEND_ID"
    }
}