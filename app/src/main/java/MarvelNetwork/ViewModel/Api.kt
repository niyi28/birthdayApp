package MarvelNetwork.ViewModel

import MarvelNetwork.Model.UserCharacteristics
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("marvel")
    fun getRequest(): Call<List<UserCharacteristics>>
    
}