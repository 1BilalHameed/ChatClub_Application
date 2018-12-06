package com.example.user.messagesapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyMessageListCustomAdaptor(val msgList:ArrayList<String>,val onItemClick:(Int,RecyclerView.ViewHolder)->Unit):RecyclerView.Adapter<MyViewHolderMessageList>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolderMessageList {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.user_message_list,p0,false)
        return MyViewHolderMessageList(view)
    }

    override fun getItemCount(): Int = msgList.size

    override fun onBindViewHolder(p0: MyViewHolderMessageList, p1: Int) {

        p0.myItem.text = msgList[p1]
        p0.itemView.setOnClickListener {

            onItemClick(p1,p0)
        }
    }

}