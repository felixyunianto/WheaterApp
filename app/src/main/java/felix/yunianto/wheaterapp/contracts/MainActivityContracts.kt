package felix.yunianto.wheaterapp.contracts

import felix.yunianto.wheaterapp.models.Weather
import felix.yunianto.wheaterapp.responses.WrappedResponse

interface MainActivityContracts{
    interface MainActivityView {
        fun showToast(message : String)
        fun attachData(weather: WrappedResponse<Weather>?)
        fun showLoading()
        fun hideLoading()
    }

    interface MainActivityPresenter{
        fun getWeather()
        fun destroy()
    }
}