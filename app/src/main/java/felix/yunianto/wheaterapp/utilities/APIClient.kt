package felix.yunianto.wheaterapp.utilities

import felix.yunianto.wheaterapp.webservices.APIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient{
    companion object{
        private var retrofit : Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()

        fun APIService() : APIService = getClient().create(APIService::class.java)

        private fun getClient() : Retrofit{
            return if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(Constants.API_ENDPOINT).client(okHttpClient).addConverterFactory(
                    GsonConverterFactory.create()).build()
                retrofit!!
            } else {
                retrofit!!
            }
        }
    }
}

class Constants {
    companion object{
        const val API_KEY = "364d285329caf93f46729cc99d4bc9d3"
        const val API_ENDPOINT = "https://api.openweathermap.org/data/2.5/"

    }
}