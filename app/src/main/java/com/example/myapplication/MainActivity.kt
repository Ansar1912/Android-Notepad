package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent


class MainActivity : AppCompatActivity() {
    val handler=Handler()
    lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runnable = Runnable {
            Intent(this, Dashboard::class.java).apply {
                startActivity(this)
                finish()
            }
        }


        handler.postDelayed(runnable, 1000)
    }

    }