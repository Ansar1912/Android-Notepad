package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.myapplication.utils.AppPrefences

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        var noteslength=AppPrefences(this).getLength()
        if(noteslength<=1)
            findViewById<TextView>(R.id.noofnotes).text="0"
        else{
            findViewById<TextView>(R.id.noofnotes).text=(noteslength-1).toString()
        }

        findViewById<Button>(R.id.addnotes).setOnClickListener(View.OnClickListener {
                    val intent= Intent(this, AddNotes::class.java)
            startActivity(intent)
        })

        findViewById<Button>(R.id.viewnotes).setOnClickListener(View.OnClickListener {
            val intent= Intent(this, ViewNotes::class.java)
            startActivity(intent)
        })


    }

}