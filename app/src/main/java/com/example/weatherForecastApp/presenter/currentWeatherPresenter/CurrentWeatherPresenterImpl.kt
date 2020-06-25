package com.example.weatherForecastApp.presenter.currentWeatherPresenter

import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.example.weatherForecastApp.presenter.row.CurrentWeatherRow
import com.example.weatherForecastApp.presenter.util.Coordinates
import com.example.weatherForecastApp.ui.WeatherView
import com.example.weatherForecastApp.weather.WeatherModel

class CurrentWeatherPresenterImpl(
    val weatherModel: WeatherModel,
    val currentWeatherDataBinder: CurrentWeatherDataBinder
) : CurrentWeatherPresenter {

    private var weatherView: WeatherView? = null
    private var currentWeatherRow: CurrentWeatherRow? = null

    private var currentWeatherData = MutableLiveData<CurrentWeatherRow>()

    private lateinit var coordinates: Coordinates


    //    TODO: coroutines
    override fun getWeatherData(location: Location) {
        initCoordinates(location)
        loadWeatherByCoors()
    }

    private fun loadWeatherByCoors() {
        if (currentWeatherRow == null) {
            object : Thread() {
                override fun run() {
                    val currentWeather = weatherModel.loadCurrentWeatherBy(coordinates)
                    if (currentWeather == null) {
                        currentWeatherData.postValue(null)
                        return
                    }
                    currentWeatherRow =
                        currentWeatherDataBinder.bindCurrentWeatherView(currentWeather)
                    currentWeatherData.postValue(currentWeatherRow)
                }
            }.start()
        } else {
            currentWeatherData.postValue(currentWeatherRow)
        }
    }

    override fun getWeatherData(cityName: String) {
        loadWeatherBy(cityName)
    }

    private fun loadWeatherBy(cityName: String) {
        if (currentWeatherRow == null) {
            object : Thread() {
                override fun run() {
                    val currentWeather = weatherModel.loadCurrentWeatherBy(cityName)
                    if (currentWeather == null) {
                        currentWeatherData.postValue(null)
                        return
                    }
                    currentWeatherRow =
                        currentWeatherDataBinder.bindCurrentWeatherView(currentWeather)
                    currentWeatherData.postValue(currentWeatherRow)
                }
            }.start()
        } else {
            currentWeatherData.postValue(currentWeatherRow)
        }
    }

    override fun getLiveData(): MutableLiveData<CurrentWeatherRow> {
        return currentWeatherData
    }

    override fun attachView(weatherView: WeatherView) {
        this.weatherView = weatherView
    }

    override fun detachView() {
        weatherView = null
    }

    private fun initCoordinates(location: Location) {
        val latitude = location.latitude.toString()
        val longitude = location.longitude.toString()
        coordinates = Coordinates(latitude, longitude)
    }
}