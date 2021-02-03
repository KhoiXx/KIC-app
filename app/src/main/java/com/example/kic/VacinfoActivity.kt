package com.example.kic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.vacinfo.*
import com.example.kic.DataHandler
import com.example.kic.sharedpreferences

class VacinfoActivity : AppCompatActivity() {
    var reference = sharedpreferences()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reference.TinyDB(this)
        setContentView(R.layout.vacinfo)
        initfunc()
        reference.putBoolean("cout1",false)

        ques1.setOnClickListener { view ->
            openandclose(ans1, "cout1")
        }
        ques2.setOnClickListener { view ->
            openandclose(ans2, "cout2")
        }
        ques3.setOnClickListener { view ->
            openandclose(ans3, "cout3")
        }
        ques4.setOnClickListener { view ->
            openandclose(ans4, "cout4")
        }
        ques5.setOnClickListener { view ->
            openandclose(ans5, "cout5")
        }
        ques6.setOnClickListener { view ->
            openandclose(ans6, "cout6")
        }









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

    private fun openandclose(answer: View, type: String) {

        var temp = reference.getBoolean(type)
        Toast.makeText(this, temp.toString(), Toast.LENGTH_SHORT).show()
        if (temp == false) {
            answer.isGone = false
            answer.isVisible = true
            temp = true
        }
        else if (temp == true) {
            answer.isGone = true
            answer.isVisible = false
            temp = false
        }

        reference.putBoolean(type, temp)

    }
}