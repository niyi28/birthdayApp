package MarvelNetwork.Views

import MarvelNetwork.Model.UserCharacteristics
import MarvelNetwork.ViewModel.RetrofitClient
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.secondbirthday.R
import com.squareup.picasso.Picasso
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
                /*resultPicture.setImageResource(R.drawable.birthdaypicture)*/
                val toast = Toast.makeText(this, "Your Birthday Gift", Toast.LENGTH_SHORT)
                toast.show()
            }
    }

    private fun picassoImageSetter(imageURI: Uri, resultPicture: ImageView){
        Picasso.get()
            .load(imageURI)
            .resize(80, 80)
            .centerCrop()
            .into(resultPicture)
    }

    private fun setQuoteAndAuthor() {
        val call: Call<List<UserCharacteristics>> = RetrofitClient().myApi.getRequest()
        call.enqueue(object : Callback<List<UserCharacteristics>> {
            override fun onResponse(call: Call<List<UserCharacteristics>>, response: Response<List<UserCharacteristics>>) {
                val responseRequest: List<UserCharacteristics> = response.body()!!
                val max: Int = responseRequest.size - 1
                val randomIndex: Int = (Math.random() * (max - 1)).toInt()
                quoteAndAuthor = responseRequest[randomIndex].character + " says happy birthday"
                val imageURI: Uri? = Uri.parse(responseRequest[randomIndex].image)

                val resultPicture: ImageView = findViewById(R.id.imageView)

                if (imageURI != null) {
                    picassoImageSetter(imageURI, resultPicture)
                }
               
                val resultTextView: TextView = findViewById(R.id.birthdayMessage)
                resultTextView.text = quoteAndAuthor
            }
            override fun onFailure(call: Call<List<UserCharacteristics>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
                Log.e("Quote error", "Error when getting qoute", t)
            }
            })
    }
}







