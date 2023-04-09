package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.NotesList
import com.example.myapplication.model.note
import com.google.gson.Gson
import com.example.myapplication.utils.AppPrefences

class ViewNotes:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewnotes)
        var noteslist=findViewById<RecyclerView>(R.id.rvNotes)
        noteslist.adapter=NotesList(getList());

    }

    fun getList():MutableList<note>{
        val gson=Gson()
        var notelist=AppPrefences(this).getAllData()
        var keys=notelist?.keys
        keys?.remove("noteslength")

        val notes = mutableListOf<note>()
        if (keys != null) {
            for (i in keys)
            {
                val notegson=gson.fromJson(notelist?.get(i).toString(),note::class.java)
                notes.add(notegson)
            }
        }
        return notes
    }

}