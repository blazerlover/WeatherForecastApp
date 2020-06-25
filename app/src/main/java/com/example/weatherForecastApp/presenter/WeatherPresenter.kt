package com.example.weatherForecastApp.presenter

import android.location.Location
import com.example.weatherForecastApp.ui.WeatherView

interface WeatherPresenter {
    fun getWeatherData(location: Location)

    fun getWeatherData(cityName: String)

    fun attachView(weatherView: WeatherView)

    fun detachView()
}
