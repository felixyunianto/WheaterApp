package felix.yunianto.wheaterapp.responses

import com.google.gson.annotations.SerializedName
import felix.yunianto.wheaterapp.models.*

data class WrappedResponse<T>(
    @SerializedName("coord") var coordinate : Coordinate,
    @SerializedName("weather") var weather : List<T>,
    @SerializedName("base") var base : String,
    @SerializedName("main") var main : Main,
    @SerializedName("visibility") var visibility : Int,
    @SerializedName("wind") var wind : Wind,
    @SerializedName("clouds") var clouds : Cloud,
    @SerializedName("dt") var dt : Long,
    @SerializedName("sys") var sys : Sys,
    @SerializedName("timezone") var timezone : Int,
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("cod") var cod : Int
)