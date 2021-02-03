package com.example.kic

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.kic.R.color

class StatusActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.status)

        val checkBox=findViewById<CheckBox>(R.id.checkBox)
        preferences = getSharedPreferences("Agree", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        val status:Boolean = preferences.getBoolean("CheckBox",false)

        checkBox.setChecked(status)
        checkBox.setOnClickListener{
            if(checkBox.isChecked == true){
                editor.putBoolean("CheckBox",true)
                editor.apply()
            }else{
                editor.putBoolean("CheckBox",false)
                editor.apply()
            }
        }
        findViewById<Button>(R.id.btn_update).setOnClickListener{view->
            Toast.makeText(this,"Updated!",Toast.LENGTH_SHORT).show()
        }
        findViewById<ImageView>(R.id.btnback).setOnClickListener{view->
            onBackPressed()
        }
    }

}