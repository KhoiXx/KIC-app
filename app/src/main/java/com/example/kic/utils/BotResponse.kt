package com.example.kic.utils

import com.example.kic.utils.Constants.OPEN_FU
import com.example.kic.utils.Constants.OPEN_GOOGLE
import com.example.kic.utils.Constants.OPEN_SEARCH

import com.example.kic.utils.Constants.OPEN_VACLOC
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Hello
            message.contains("Hello") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Hi"
                    2 -> "Annyeonghaseyo!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            message.contains("vaccine") && (message.contains("location") || message.contains("places") )-> {
                OPEN_VACLOC
            }

            message.contains("add") && (message.contains("symptom") || message.contains("feeling") )-> {
                OPEN_FU
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "Sorry! I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "You're very nice"
                    else -> "error"
                }
            }
        }
    }
}