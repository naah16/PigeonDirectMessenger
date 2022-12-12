package com.example.pigeondirectmessenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

const val USER_ID = 0
const val OTHER_ID = 1

class MainActivity : AppCompatActivity() {
    private var fromUser = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListeners()
        setUpRecyclerView()

    }

    private fun setUpListeners() {
        send_button.setOnClickListener{
            val messageText = message_editText.text.toString()
            message_editText.setText("")

            val adapter = message_list.adapter
            if(adapter is MessageAdapter) {
                val message = ChatMessage(messageText, if(fromUser) USER_ID else OTHER_ID)
                adapter.addItem(message)
                message_list.scrollToPosition(adapter.itemCount-1)
                fromUser = !fromUser
            }
        }
    }

    private fun setUpRecyclerView() {
        //configura o RecyclerView
        message_list.layoutManager = LinearLayoutManager(this)
        message_list.adapter = MessageAdapter()
    }
}