package felix.yunianto.wheaterapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Main (
    @SerializedName("temp") var temp : String?,
    @SerializedName("feels_like") var feels_like : String?,
    @SerializedName("temp_min") var temp_min : String?,
    @SerializedName("temp_max") var temp_max : String?,
    @SerializedName("pressure") var pressure : String?,
    @SerializedName("humidity") var humidity : String?
) : Parcelable{
    constructor() : this(null,null,null,null,null, null)
}