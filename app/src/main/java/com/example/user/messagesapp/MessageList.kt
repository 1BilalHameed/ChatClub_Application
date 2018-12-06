package com.example.user.messagesapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_message_list.*

class MessageList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)

        // getting username from loginActivity
        findViewById<TextView>(R.id.userTitleTxt).text = intent.getStringExtra("username")

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = MyMessageListCustomAdaptor(arrayListOf("Bilal","Faisal","Sir Ishaq","Sir Arbaaz"
        ,"Muhammad Umer","Sikander","Umair Zafar","Noman","Nadir Shah",
        "Munaish","Durab Jami","Sarah","Rumaisa","Aslam"),::onItemClick)


    }

    fun onItemClick(positon:Int,holder:RecyclerView.ViewHolder)
    {
        val intent = Intent(this,ChatBox::class.java)
        startActivity(intent)
    }
}
