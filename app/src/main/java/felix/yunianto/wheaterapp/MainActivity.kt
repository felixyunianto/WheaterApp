package felix.yunianto.wheaterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import felix.yunianto.wheaterapp.contracts.MainActivityContracts
import felix.yunianto.wheaterapp.models.Weather
import felix.yunianto.wheaterapp.presenters.MainActivityPresenter
import felix.yunianto.wheaterapp.responses.WrappedResponse
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), MainActivityContracts.MainActivityView{
    private var presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
    }

    private fun getWeather() = presenter?.getWeather()

    override fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }

    override fun attachData(weather: WrappedResponse<Weather>?) {

        address.text = weather?.name + " "+ weather?.sys?.country
        updatedAt.text = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(weather?.dt?.let { Date(it * 1000) })
        temp.text = weather?.main?.temp + "°C"
        tempMin.text = "Min Temp: "+weather?.main?.temp_min + "°C"
        tempMax.text = "Max Temp: "+weather?.main?.temp_max + "°C"
        pressure.text = weather?.main?.pressure
        humidity.text = weather?.main?.humidity
        sunrise.text = weather?.sys?.sunrise
        sunset.text = weather?.sys?.sunset
        wind.text = weather?.wind?.speed
        status.text = weather?.weather?.get(0)?.description?.capitalize()


    }

    override fun showLoading() {
        loader.apply {
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        loader.apply {
            isIndeterminate = false
            progress = 0
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }

    override fun onResume() {
        super.onResume()
        getWeather()
    }
}