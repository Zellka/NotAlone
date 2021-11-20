package com.example.notalone

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notalone.databinding.ItemMessageBinding

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()

    class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentMessage: Message) {
            when (currentMessage.id) {
                Companion.SEND_ID -> {
                    binding.yourMessage.apply {
                        text = currentMessage.message
                        visibility = View.VISIBLE
                    }
                    binding.botMessage.visibility = View.GONE
                }
                Companion.RECEIVE_ID -> {
                    binding.botMessage.apply {
                        text = currentMessage.message
                        visibility = View.VISIBLE
                    }
                    binding.yourMessage.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder =
        MessageViewHolder(
            ItemMessageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = messagesList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messagesList[position]
        holder.bind(currentMessage)
    }

    fun insertMessage(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }

    companion object {
        const val SEND_ID = "SEND_ID"
        const val RECEIVE_ID = "RECEIVE_ID"
    }
}