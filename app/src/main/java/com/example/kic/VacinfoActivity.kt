package com.example.kic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class VacinfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vacinfo)
        initfunc()


        findViewById<ImageView>(R.id.btnback).setOnClickListener{ view->
            onBackPressed()
        }
    }

    private fun initfunc(){
        val ques1=findViewById<TextView>(R.id.ques1)
        val ques2=findViewById<TextView>(R.id.ques2)
        val ques3=findViewById<TextView>(R.id.ques3)
        val ques4=findViewById<TextView>(R.id.ques4)
        val ques5=findViewById<TextView>(R.id.ques5)
        val ques6=findViewById<TextView>(R.id.ques6)
        val ans1=findViewById<TextView>(R.id.ans1)
        val ans2=findViewById<TextView>(R.id.ans2)
        val ans3=findViewById<TextView>(R.id.ans3)
        val ans4=findViewById<TextView>(R.id.ans4)
        val ans5=findViewById<TextView>(R.id.ans5)
        val ans6=findViewById<TextView>(R.id.ans6)

        ans1.visibility = View.GONE
        ans2.visibility = View.GONE
        ans3.visibility = View.GONE
        ans4.visibility = View.GONE
        ans5.visibility = View.GONE
        ans6.visibility = View.GONE


    }
}