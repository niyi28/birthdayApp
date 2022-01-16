package com.example.birthdayApp

import Network.QuoteAndAuthor
import Network.RetrofitClient
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.secondbirthday.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
     var quoteAndAuthor: String = "No Quote"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tickCard: Button = generateButtonReference(R.id.button)
        setClickListener(tickCard)

        }


    private fun generateButtonReference(buttonId: Int): Button{
        return  findViewById(buttonId)
    }
    
    private fun setClickListener(buttonReference: Button){
            buttonReference.setOnClickListener(){

                setQuoteAndAuthor()

                val resultPicture: ImageView = findViewById(R.id.imageView)
                resultPicture.setImageResource(R.drawable.birthdaypicture)
                val toast = Toast.makeText(this, "Your Birthday Gift", Toast.LENGTH_SHORT)
                toast.show()
            }
    }

    private fun setQuoteAndAuthor() {
        val call: Call<List<QuoteAndAuthor>> = RetrofitClient().myApi.getRequest()
        call.enqueue(object : Callback<List<QuoteAndAuthor>> {
            override fun onResponse(call: Call<List<QuoteAndAuthor>>, response: Response<List<QuoteAndAuthor>>) {
                val responseRequest: List<QuoteAndAuthor> = response.body()!!
                val max: Int = responseRequest.size - 1
                val randomIndex: Int = (Math.random() * (max - 1)).toInt()
                quoteAndAuthor = responseRequest[randomIndex].programmingQuote + " by " + responseRequest[randomIndex].author
                val resultTextView: TextView = findViewById(R.id.birthdayMessage)
                resultTextView.text = quoteAndAuthor
            }
            override fun onFailure(call: Call<List<QuoteAndAuthor>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
                Log.e("Quote error", "Error when getting qoute", t)
            }
            })
    }
}

