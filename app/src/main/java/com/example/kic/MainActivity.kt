package com.example.kic

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kic.R.color
import com.example.kic.R.color.red
import com.example.kic.ui.PopActivity

class MainActivity : AppCompatActivity() {
    var response: Int = 0
    lateinit var SharedPreferences: SharedPreferences
    var newstatus: Boolean = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_menu: ImageView = findViewById(R.id.btn_menu);
        val loginmenu: LinearLayout = findViewById(R.id.loginmenu)
        val cover: LinearLayout = findViewById(R.id.cover)
        val btn_login: Button = findViewById(R.id.btn_login)
        val group1: ConstraintLayout = findViewById(R.id.group1)
        val group2: ConstraintLayout = findViewById(R.id.group2)
        val btn_pro: TextView = findViewById(R.id.btn_pro)
        val statustxt: TextView = findViewById(R.id.statustxt)
        val btn_vacloc: TextView = findViewById(R.id.btn_Vacloc)

        SharedPreferences = getSharedPreferences("Agree", Context.MODE_PRIVATE)
        newstatus = SharedPreferences.getBoolean("CheckBox", false)


        btn_menu.setOnClickListener { view ->
            loginmenu.animate().translationX(0f)
            cover.visibility = View.VISIBLE
            // frag.visibility = View.VISIBLE
        }
        cover.setOnClickListener { view ->
            loginmenu.animate().translationX(640f)
            cover.visibility = View.INVISIBLE
            //frag.visibility = View.GONE

        }
        btn_login.setOnClickListener {
            group1.visibility = View.GONE
            group2.visibility = View.VISIBLE
        }
        btn_pro.setOnClickListener {
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.btn_med).setOnClickListener { view ->
            intent = Intent(this, MedconActivity::class.java)
            startActivity(intent)
        }
        /*findViewById<TextView>(R.id.btn_resforvac).setOnClickListener { view ->
            /*Toast.makeText(this, "Not available. Please choose another one", Toast.LENGTH_LONG)
                .show()*/
            val url = "https://docs.google.com/forms/d/e/1FAIpQLSeZNoXfOlzs6L_GCkgz9mwjToU6RheWYSOqCY5JWne0uQW6bA/viewform"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }*/
        findViewById<TextView>(R.id.btn_status).setOnClickListener { view ->
            intent = Intent(this, StatusActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.btn_fu2).setOnClickListener { view ->
            intent = Intent(this,FollowupActivity::class.java)
            startActivity(intent)
        }

        btn_vacloc.setOnClickListener {
            intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        loginmenu.setOnClickListener { view ->
            newstatus = SharedPreferences.getBoolean("CheckBox", false)
            if (newstatus == false) {
                statustxt.setText("Not Register")
                statustxt.setTextColor(red)
            } else {
                statustxt.setText("Register")
                statustxt.setTextColor(color.green)
            }
        }
    }

    fun getUrlFromIntent(view: View) {
        val url =
            "https://docs.google.com/forms/d/e/1FAIpQLSeZNoXfOlzs6L_GCkgz9mwjToU6RheWYSOqCY5JWne0uQW6bA/viewform"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
    fun chatbot(view: View){
        val intent = Intent(this, PopActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBackPressed() {
        super.onBackPressed()
        val loginmenu: LinearLayout = findViewById(R.id.loginmenu)
        val cover: LinearLayout = findViewById(R.id.cover)
        newstatus = SharedPreferences.getBoolean("CheckBox", false)
        val statustxt: TextView = findViewById(R.id.statustxt)
        loginmenu.animate().translationX(640f)
        cover.visibility = View.INVISIBLE
        if (newstatus == false) {
            statustxt.setText("Not Register")
            statustxt.setTextColor(red)
        } else {
            statustxt.setText("Register")
            statustxt.setTextColor(color.green)
        }
    }
}