package felix.yunianto.wheaterapp.models

import android.accounts.AuthenticatorDescription
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    @SerializedName("id") var id : Int?,
    @SerializedName("main") var main : String?,
    @SerializedName("description") var description: String?,
    @SerializedName("icon") var icon : String?

) : Parcelable {
    constructor() : this(null,null,null,null)
}