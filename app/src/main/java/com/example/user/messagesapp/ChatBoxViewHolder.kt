package com.example.user.messagesapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ChatBoxViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
{
    val myuserOneTxt = itemView.findViewById<TextView>(R.id.userone_txt)
    val myImage = itemView.findViewById<ImageView>(R.id.user_two_image_view_tv)
}