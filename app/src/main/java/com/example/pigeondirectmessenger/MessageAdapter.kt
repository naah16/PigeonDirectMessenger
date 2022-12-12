package com.example.pigeondirectmessenger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val SENT_MESSAGE = 0
const val RECEIVED_MESSAGE = 1

class MessageAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //lista de mensagens
    private val items: MutableList<ChatMessage> = mutableListOf()

    fun addItem(message: ChatMessage) {
        items.add(message)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val card = LayoutInflater
            .from(parent.context)
            .inflate(
                if(viewType == SENT_MESSAGE)
                    R.layout.send_card
                else R.layout.received_card, parent, false)
        return MessageViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentItem = items[position]
        if(holder is MessageViewHolder) {
            holder.messageTextView.text = currentItem.text
        }
    }

    override fun getItemCount() = items.size


    override fun getItemViewType(position: Int) =
        if(items[position].senderId == USER_ID) {
            SENT_MESSAGE
        } else {
            RECEIVED_MESSAGE
        }


    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val messageTextView: TextView = itemView.findViewById(R.id.message_textView)
    }
}