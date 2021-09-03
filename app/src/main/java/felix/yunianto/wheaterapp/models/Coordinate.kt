package felix.yunianto.wheaterapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinate(
    @SerializedName("lon") var lon : Double?,
    @SerializedName("lat") var lat : Double?
) : Parcelable {
    constructor() : this(null, null)
}