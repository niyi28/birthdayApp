package Network

import com.google.gson.annotations.SerializedName

class QuoteAndAuthor (@field:SerializedName("en") val programmingQuote: String,
                      @field:SerializedName("author") val author: String)