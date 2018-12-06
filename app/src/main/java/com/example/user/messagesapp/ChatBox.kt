package com.example.user.messagesapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_chat_box.*

class ChatBox : AppCompatActivity() {

    val listOfMsg = ArrayList<ModelClass>()
    var selectImage:Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_box)

        myRecyclerViewTwo.layoutManager = LinearLayoutManager(this)
        myRecyclerViewTwo.adapter = MyChatBoxCustomAdaptor(listOfMsg)

        var sendingId = 1
        btnSend.setOnClickListener {

            imageDisplayer.visibility = View.GONE
            val userMsgText = findViewById<EditText>(R.id.userPostEd).text.toString()
            if (userMsgText!=null)
            {
                listOfMsg.add(ModelClass(msg = userMsgText,myUserId = sendingId,image = selectImage))
                if (sendingId==1)
                {
                    sendingId = 0
                }
                else
                {
                    sendingId = 1
                }

                userPostEd.setText("")
                selectImage = null
                val lastPositon = listOfMsg.size-1
                myRecyclerViewTwo.adapter?.notifyItemInserted(lastPositon)
                myRecyclerViewTwo.scrollToPosition(lastPositon)


            }
        }

        // uploading image intent code here for chat box
        uploadImageIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 1)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data!=null)
        {
           if(requestCode==1 && resultCode== Activity.RESULT_OK)
           {
               val photoUri: Uri = data.data
               selectImage = MediaStore.Images.Media.getBitmap(this.contentResolver,photoUri)
               val myPicDisplayer = findViewById<ImageView>(R.id.imageDisplayer)
               myPicDisplayer.setImageBitmap(selectImage)
               myPicDisplayer.visibility = View.VISIBLE
           }
        }
    }
}
