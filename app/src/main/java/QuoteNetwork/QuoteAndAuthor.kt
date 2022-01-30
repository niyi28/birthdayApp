package MarvelNetwork

import com.google.gson.annotations.SerializedName

class QuoteAndAuthor (@field:SerializedName("name") val programmingQuote: String,
                      @field:SerializedName("imageurl") val author: String)