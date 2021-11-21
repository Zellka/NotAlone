package com.example.notalone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notalone.R
import com.example.notalone.entity.Provider
import com.example.notalone.entity.Services


class ProviderAdapter(var items: List<Provider>, private val listener: ClickListener2) :
    RecyclerView.Adapter<ProviderAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BookHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_provider, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            listener.showProvider(items[position])
        }
    }

    inner class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.item_p_name)
        private val address = itemView.findViewById<TextView>(R.id.item_p_address)
        private val text = itemView.findViewById<TextView>(R.id.item_p_text)
        private val price = itemView.findViewById<TextView>(R.id.item_p_price)

        fun bind(item: Provider) {
            text.text = item.text
            name.text = item.name
            address.text = item.address
            price.text = item.price
        }
    }
}

interface ClickListener2 {
    fun showProvider(book: Provider)
}