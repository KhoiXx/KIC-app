package com.example.kic.ui

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import com.example.kic.FollowupActivity
import com.example.kic.MainActivity
import com.example.kic.MapsActivity

import com.example.kic.R
import com.example.kic.utils.Constants.SEND_ID
import com.example.kic.utils.Time
import kotlinx.coroutines.*
import kotlinx.android.synthetic.main.chatbot.*
import com.example.kic.data.Message

import com.example.kic.utils.BotResponse
import com.example.kic.utils.Constants
import com.example.kic.utils.Constants.OPEN_FU
import com.example.kic.utils.Constants.RECEIVE_ID
import com.example.kic.utils.Constants.SEND_ID
import com.example.kic.utils.Constants.OPEN_GOOGLE
import com.example.kic.utils.Constants.OPEN_SEARCH
import com.example.kic.utils.Constants.OPEN_VACLOC

class PopActivity : Activity() {

    private val TAG = "PopActivity"

    //You can ignore this messageList if you're coming from the tutorial,
    // it was used only for my personal debugging
    var messagesList = mutableListOf<Message>()

    private lateinit var adapter: MessagingAdapter
    private val botList = listOf("NoCov", "KIC_cutebot", "Hiphopneverdie")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chatbot)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * 0.7).toInt(), (height * 0.6).toInt())
        /*val sendbutton = findViewById<FloatingActionButton>(R.id.sendbutton)
        val tv_message:TextView = findViewById(R.id.tv_message)
        val txtchat =findViewById<EditText>(R.id.txtchat)
        sendbutton.setOnClickListener {
            if(txtchat.getText().toString() != ""){
                tv_message.setText(txtchat.getText().toString())
            }
            Toast.makeText(this, "Sorry!", Toast.LENGTH_LONG).show()
        }*/

        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("Hello! I'm ${botList[random]}")
        customBotMessage("How are you today?")
    }
    private fun clickEvents() {

        //Send a message
        btn_send.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Message(message, Constants.SEND_ID, timeStamp))
            et_message.setText("")

            adapter.insertMessage(Message(message, Constants.SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }
    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(Message(message, RECEIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Fake response delay
            delay(1000)

            withContext(Dispatchers.Main) {
                //Gets the response
                val response = BotResponse.basicResponses(message)

                //Adds it to our local list
                messagesList.add(Message(response, RECEIVE_ID, timeStamp))

                //Inserts our message into the adapter
                adapter.insertMessage(Message(response, RECEIVE_ID, timeStamp))

                //Scrolls us to the position of the latest message
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //Starts Google
                when (response) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }
                    OPEN_VACLOC -> {
                        intent = Intent(this@PopActivity, MapsActivity::class.java)
                        startActivity(intent)
                    }
                    OPEN_FU -> {
                        intent = Intent(this@PopActivity, FollowupActivity::class.java)
                        startActivity(intent)
                    }

                }
            }
        }
    }
}
