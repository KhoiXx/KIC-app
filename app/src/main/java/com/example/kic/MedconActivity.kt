package com.example.kic

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.kic.ui.MessagingAdapter
import kotlinx.android.synthetic.main.medcon.*

class MedconActivity : AppCompatActivity() {
    lateinit var SharedPreferences: SharedPreferences
    var checkmed:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.medcon)
        findViewById<Button>(R.id.btn_update).setOnClickListener{ view->
            Toast.makeText(this,"Updated!", Toast.LENGTH_LONG).show()
        }
        findViewById<ImageView>(R.id.btnback).setOnClickListener{view->
            onBackPressed()
        }

    }
    private fun getStatus(input: String){
        SharedPreferences = getSharedPreferences("Medcon", Context.MODE_PRIVATE)
        checkmed = SharedPreferences.getBoolean(input,false)
    }

}