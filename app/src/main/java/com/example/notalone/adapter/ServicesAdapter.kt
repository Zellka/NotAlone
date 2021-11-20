package com.example.notalone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notalone.R
import com.example.notalone.entity.Services


class ServicesAdapter(var items: List<Services>, private val listener: ClickListener) :
    RecyclerView.Adapter<ServicesAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BookHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_services, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            listener.showServices(items[position])
        }
    }

    inner class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fon = itemView.findViewById<LinearLayout>(R.id.item_fon_fon)
        private val image = itemView.findViewById<ImageView>(R.id.item_fon_image)
        private val text = itemView.findViewById<TextView>(R.id.item_fon_text)

        fun bind(item: Services) {
            text.text = item.text
            image.setImageResource(item.image)
            fon.setBackgroundResource(item.fon)
        }
    }
}

interface ClickListener {
    fun showServices(book: Services)
}