package felix.yunianto.wheaterapp.webservices

import felix.yunianto.wheaterapp.models.Weather
import felix.yunianto.wheaterapp.responses.WrappedResponse
import felix.yunianto.wheaterapp.utilities.Constants
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("weather?q=Tegal&units=metric&appid=${Constants.API_KEY}")
    fun getWeather() : Call<WrappedResponse<Weather>>
}