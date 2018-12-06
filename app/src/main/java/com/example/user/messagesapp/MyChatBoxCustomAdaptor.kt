package com.example.user.messagesapp
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyChatBoxCustomAdaptor(val msgList:ArrayList<ModelClass>):RecyclerView.Adapter<ChatBoxViewHolder>() {
    val MESSAGE_USER = 0
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ChatBoxViewHolder {
        if (p1==MESSAGE_USER)
        {
            val v = LayoutInflater.from(p0.context).inflate(R.layout.chat_user_one,p0,false)
            return ChatBoxViewHolder(v)
        }
        else
        {
            val v = LayoutInflater.from(p0.context).inflate(R.layout.user_two_chat,p0,false)
            return ChatBoxViewHolder(v)
        }
    }

    override fun getItemCount(): Int = msgList.size

    override fun onBindViewHolder(p0: ChatBoxViewHolder, p1: Int) {

        p0.myuserOneTxt.text = msgList[p1].msg
        p0.myImage.setImageBitmap(msgList[p1].image)
    }

    override fun getItemViewType(position: Int): Int {

        return msgList[position].myUserId
    }
}