package com.example.kic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class FollowupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.followup)

        findViewById<ImageView>(R.id.btnback).setOnClickListener{ view->
            onBackPressed()
        }
    }

    fun addsymptom(view: View) {
        Toast.makeText(this,"Sorry! Not available",Toast.LENGTH_SHORT).show()
    }
}