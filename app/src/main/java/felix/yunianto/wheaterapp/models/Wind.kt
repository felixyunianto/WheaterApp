package felix.yunianto.wheaterapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wind(
    @SerializedName("speed") var speed : String?,
    @SerializedName("deg") var deg : Int?
) : Parcelable{
    constructor() : this(null, null)
}