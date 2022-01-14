package com.example.secondbirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tickCard: Button = generateButtonReference(R.id.button)
        setClickListener(tickCard)
    }
   
    fun generateButtonReference(buttonId: Int): Button{
        return findViewById(buttonId)
    }

    fun setClickListener(buttonReference: Button){
        buttonReference.setOnClickListener(){
            val resultTextView: TextView = findViewById(R.id.birthdayMessage)
            resultTextView.text = "With love my good friend!!!!!!"
            val resultPicture: ImageView = findViewById(R.id.imageView)
            resultPicture.setImageResource(R.drawable.birthdaypicture)
            /*val toast = Toast.makeText(this, "Your Birthday", Toast.LENGTH_SHORT)
            toast.show()*/
        }
    }
}