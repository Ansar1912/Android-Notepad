package com.example.myapplication.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.note

class NotesList(var noteList:MutableList<note>): RecyclerView.Adapter<NotesList.ProductViewHolder>() {

    class ProductViewHolder(view: View):RecyclerView.ViewHolder(view){
        val notetitle=view.findViewById<TextView>(R.id.title)
        val notedesc=view.findViewById<TextView>(R.id.notes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val notes = noteList[position]
        holder.notetitle.text=notes.title
        holder.notedesc.text = notes.notes
    }
}