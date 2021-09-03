package felix.yunianto.wheaterapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sys(
    @SerializedName("type") var type : Int?,
    @SerializedName("id") var id : Int?,
    @SerializedName("message") var message : Int?,
    @SerializedName("country") var country : String?,
    @SerializedName("sunrise") var sunrise : String?,
    @SerializedName("sunset") var sunset : String?
) : Parcelable{
    constructor() : this(null,null,null,null,null,null)
}