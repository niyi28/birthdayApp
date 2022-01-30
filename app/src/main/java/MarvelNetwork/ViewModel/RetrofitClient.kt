package MarvelNetwork.ViewModel

import MarvelNetwork.QuoteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val marvelBASE_URL = "https://simplifiedcoding.net/demos/"

class RetrofitClient() {
    val myApi: QuoteApi

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(marvelBASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(QuoteApi::class.java)
    }

}