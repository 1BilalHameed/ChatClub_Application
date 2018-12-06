package com.example.user.messagesapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    companion object {
        val userList = ArrayList<ModelClass>()
    }

    val myError = "Field Can Not Be Empty!!"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSubmit.setOnClickListener {

            var user_name = findViewById<EditText>(R.id.user_ed_signup).text.toString()
            val user_password = findViewById<EditText>(R.id.pass_ed_signup).text.toString()
            val user_confrim_password = findViewById<EditText>(R.id.passconfrim_ed_signup).text.toString()

            if(user_name.length==0)
            {
                user_ed_signup.requestFocus()
                user_ed_signup.error = myError
            }
            else if(user_password.length==0)
            {
                pass_ed_signup.requestFocus()
                pass_ed_signup.error = myError
            }
            else if(user_confrim_password.length==0)
            {
                passconfrim_ed_signup.requestFocus()
                passconfrim_ed_signup.error = myError
            }
            else if (user_confrim_password!=user_password)
            {
                passconfrim_ed_signup.requestFocus()
                passconfrim_ed_signup.error = "Password Miss Match!!"
            }
            else
            {
                userList.add(ModelClass(user_name,user_password))
                Activity.RESULT_OK
                finish()
                showToast("Account Created ${userList[0].myUserName}")

            }
        }
    }

    fun Context.showToast(msg:String)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
