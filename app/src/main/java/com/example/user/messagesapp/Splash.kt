package com.example.user.messagesapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {

    val duration:Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {

            kotlin.run {

                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        },duration)
    }
}
