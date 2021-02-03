package com.example.kic

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import com.example.kic.R.string
import com.google.android.material.snackbar.Snackbar
import android.content.SharedPreferences as SharedPreferences1

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val btn_menu = findViewById<ImageButton>(R.id.btn_menu)
        val btnback = findViewById<ImageView>(R.id.btnback)
        val loginmenu: LinearLayout = findViewById(R.id.loginmenu)
        val cover: LinearLayout = findViewById(R.id.cover)
        val btn_update = findViewById<Button>(R.id.btn_update)
        val name = findViewById<EditText>(R.id.name)
        val age = findViewById<EditText>(R.id.age)
        val sex = findViewById<EditText>(R.id.sex)
        val id= findViewById<EditText>(R.id.id)
        val job=findViewById<EditText>(R.id.job)
        val hometown = findViewById<EditText>(R.id.hometown)

        var nametxt = "NoCov"
        var agetxt = "21"
        var sextxt = "M"
        var idtxt = "01012021"
        var jobtxt = "Student"
        var hometowntxt = "HoChiMinh city"

        name.setText(nametxt)
        age.setText(agetxt)
        sex.setText(sextxt)
        id.setText(idtxt)
        job.setText(jobtxt)
        hometown.setText(hometowntxt)
        btn_update.setOnClickListener { view ->
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        }

        btnback.setOnClickListener {
            onBackPressed()
        }

    }
}