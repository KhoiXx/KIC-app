package com.example.kic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.vacinfo.*
import com.example.kic.DataHandler
import com.example.kic.sharedpreferences

class VacinfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vacinfo)


        initfunc()
        var cout1 = 0
        var cout2 = 0
        var cout3 = 0
        var cout4 = 0
        var cout5 = 0
        var cout6 = 0


        openandclose(ques1,ans1,"cout1")
        openandclose(ques2,ans1,"cout2")
        openandclose(ques3,ans1,"cout3")
        openandclose(ques4,ans1,"cout4")
        openandclose(ques5,ans1,"cout5")
        openandclose(ques6,ans1,"cout6")




        findViewById<ImageView>(R.id.btnback).setOnClickListener { view ->
            onBackPressed()
        }
    }

    private fun initfunc() {
        val ques1 = findViewById<TextView>(R.id.ques1)
        val ques2 = findViewById<TextView>(R.id.ques2)
        val ques3 = findViewById<TextView>(R.id.ques3)
        val ques4 = findViewById<TextView>(R.id.ques4)
        val ques5 = findViewById<TextView>(R.id.ques5)
        val ques6 = findViewById<TextView>(R.id.ques6)
        val ans1 = findViewById<TextView>(R.id.ans1)
        val ans2 = findViewById<TextView>(R.id.ans2)
        val ans3 = findViewById<TextView>(R.id.ans3)
        val ans4 = findViewById<TextView>(R.id.ans4)
        val ans5 = findViewById<TextView>(R.id.ans5)
        val ans6 = findViewById<TextView>(R.id.ans6)

        ans1.visibility = View.GONE
        ans2.visibility = View.GONE
        ans3.visibility = View.GONE
        ans4.visibility = View.GONE
        ans5.visibility = View.GONE
        ans6.visibility = View.GONE
    }

    private fun openandclose(question: View, answer: View,type:String) {
        var temp = false
        question.setOnClickListener { view ->
            if (temp == false) {
                answer.visibility = View.VISIBLE
                temp = true
            }
            if (temp == true) {
                answer.visibility = View.GONE
                temp = false
            }
        }

    }
}