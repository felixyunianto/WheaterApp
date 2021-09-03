package felix.yunianto.wheaterapp.presenters

import felix.yunianto.wheaterapp.contracts.MainActivityContracts
import felix.yunianto.wheaterapp.models.Weather
import felix.yunianto.wheaterapp.responses.WrappedResponse
import felix.yunianto.wheaterapp.utilities.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter(v : MainActivityContracts.MainActivityView?) : MainActivityContracts.MainActivityPresenter {
    private var view : MainActivityContracts.MainActivityView? = v
    private var apiService = APIClient.APIService()

    override fun getWeather() {
        val request = apiService.getWeather()
        view?.showLoading()
        request.enqueue(object : Callback<WrappedResponse<Weather>>{
            override fun onFailure(call: Call<WrappedResponse<Weather>>, t: Throwable) {
                println("Log : ${t.message}")
                view?.showToast("Cannot connect to server")
            }

            override fun onResponse(
                call: Call<WrappedResponse<Weather>>,
                response: Response<WrappedResponse<Weather>>
            ) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        view?.attachData(body)
                        view?.hideLoading()
                    }else{
                        view?.hideLoading()
                        view?.showToast("Something went wrong")
                    }
                }
            }

        })
    }

    override fun destroy() {
        view = null
    }

}