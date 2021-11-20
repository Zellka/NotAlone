package com.example.notalone.friends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notalone.R
import com.example.notalone.adapter.MessageAdapter
import com.example.notalone.common.FriendResponse
import com.example.notalone.databinding.ActivityDialogBinding
import com.example.notalone.entity.Message
import kotlinx.coroutines.*

class DialogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDialogBinding

    private var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        adapter = MessageAdapter()
        binding.rvMessages.adapter = adapter
        binding.rvMessages.layoutManager = LinearLayoutManager(this)

        binding.btnSend.setOnClickListener {
            val message = binding.enterMessage.text.toString()

            if (message.isNotEmpty()) {
                messagesList.add(Message(message, SEND_ID))
                binding.enterMessage.setText("")

                adapter.insertMessage(Message(message, SEND_ID))
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

                response(message)
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
        customMessage(getString(R.string.first_mes_for_you))
    }

    private fun response(message: String) {
        GlobalScope.launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                val response = FriendResponse.getBasicResponses(message)
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

    private fun customMessage(message: String) {
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                messagesList.add(Message(message, RECEIVE_ID))
                adapter.insertMessage(Message(message, RECEIVE_ID))

                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        private const val RECEIVE_ID = "RECEIVE_ID"
        private const val SEND_ID = "SEND_ID"
    }
}