package com.example.pigeondirectmessenger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //lista de mensagens
    val items: List<String> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
        LayoutInflater.from(parent.context).inflate(R.layout.message_card, parent, false)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
        val currentItem = items[position]
        if(holder is MessageViewHolder) {
            holder.messageTextView.text = currentItem
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return items.size
    }

    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val messageTextView: TextView = itemView.findViewById(R.id.message_textView)
    }
}