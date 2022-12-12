package com.example.pigeondirectmessenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_button.setOnClickListener{
            val message = message_editText.text.toString()
            message_editText.setText("")
            //message_textView.text = message
        }

        //configura o RecyclerView
        message_list.layoutManager = LinearLayoutManager(this)
        message_list.adapter = MessageAdapter()

    }
}