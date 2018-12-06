package com.example.user.messagesapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.util.function.Consumer

class LoginActivity : AppCompatActivity() {

    val INTENT_CODE = 1
    val myError = "Fields Can Not Be Empty!!"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Sign Up Button action handling(Moving to signUP Activity)
        btnSignUp.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivityForResult(intent,INTENT_CODE)
        }

        //Sign In action handling (validating fields and Moving to MessageList Activity)
        btnSign.setOnClickListener {

            val username = findViewById<EditText>(R.id.user_ed_login).text.toString()
            val password = findViewById<EditText>(R.id.pass_ed_login).text.toString()

            SignUp.userList.forEach {

                if(username.length==0)
                {
                    user_ed_login.requestFocus()
                    user_ed_login.error = myError
                }
                else if(username!=it.myUserName)
                {
                    user_ed_login.requestFocus()
                    user_ed_login.error = "Invalid UserName!"
                }
                else if(password.length==0)
                {
                    pass_ed_login.requestFocus()
                    pass_ed_login.error = myError
                }
                else if(password!=it.myUserPassword)
                {
                    pass_ed_login.requestFocus()
                    pass_ed_login.error = "Invalid Password!"
                }
                else
                {
                    val intent = Intent(this,MessageList::class.java)
                    intent.putExtra("username","Welcome ${it.myUserName}")
                    startActivity(intent)
                    user_ed_login.setText("")
                    pass_ed_login.setText("")
                    Toast.makeText(this,"Sucessfully Login :)",Toast.LENGTH_SHORT).show()
                }


            }


        }

    }


}
