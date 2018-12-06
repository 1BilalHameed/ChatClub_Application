package com.example.user.messagesapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MyViewHolderMessageList(itemView:View):RecyclerView.ViewHolder(itemView)
{
    val myItem = itemView.findViewById<TextView>(R.id.tvTxt)
}