package com.example.myapplication;

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.note
import com.example.myapplication.utils.AppPrefences
import com.google.gson.Gson

class AddNotes : AppCompatActivity() {
    private val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addnotes)
        val prefences= AppPrefences(this)
        findViewById<Button>(R.id.submit).setOnClickListener(View.OnClickListener {
            val notes=findViewById<EditText>(R.id.notes).text.toString()
            if(notes.length>500)
            {
                showMessageOnUI("Notes Length Exceded")
            }
            else if(notes.isEmpty()){
                showMessageOnUI("Notes Empty")
            }
            else{
                val title=findViewById<EditText>(R.id.title).text.toString()
                val notetext=findViewById<EditText>(R.id.notes).text.toString()
                val gson_notes=gson.toJson(note(title,notetext),note::class.java)
                prefences.setData(prefences.getLength().toString(),gson_notes)
                prefences.getLength()
                prefences.addlength();
                val intent= Intent(this, Dashboard::class.java)
                startActivity(intent)
            }
        })
    }
    fun showMessageOnUI(message:String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

}
