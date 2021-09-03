package felix.yunianto.wheaterapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cloud(
    @SerializedName("all") var all : Int?
) : Parcelable{
    constructor() : this(null)
}