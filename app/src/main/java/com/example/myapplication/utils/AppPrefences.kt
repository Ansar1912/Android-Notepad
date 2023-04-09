package com.example.myapplication.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.icu.number.IntegerWidth
import android.util.Log
import com.example.myapplication.model.note

class AppPrefences (var context: Context) {
    private val prefences=context.getSharedPreferences("iNoteBook",MODE_PRIVATE)

    fun setData(key:String,value:String){

        prefences.edit().putString(key.toString(),value).apply()
    }
    fun getData(key: String):String?{
        return prefences.getString(key,"0");
    }

    fun addlength(){
        val noteslen=prefences.getString("noteslength","0")?:"0"
        val len= Integer.parseInt(noteslen)+1
        prefences.edit().putString("noteslength",len.toString()).apply()
    }
    fun getLength():Int
    {
        val list=prefences.getAll()
        return list.size
    }
    fun clearAllData(){
        prefences.edit().clear().apply()
    }

    fun getAllData(): MutableMap<String, *>? {
        return prefences.getAll()
    }

}