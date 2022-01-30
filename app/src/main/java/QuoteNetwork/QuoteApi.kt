package MarvelNetwork

import MarvelNetwork.Model.UserCharacteristics
import retrofit2.Call
import retrofit2.http.GET

interface QuoteApi {
    @GET("marvel")
    fun getRequest(): Call<List<UserCharacteristics>>
    
}