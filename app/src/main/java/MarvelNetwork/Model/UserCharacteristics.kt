package MarvelNetwork.Model

import com.google.gson.annotations.SerializedName

class UserCharacteristics (@field:SerializedName("name") val character: String,
                           @field:SerializedName("imageurl") val image: String)