package com.example.weatherForecastApp

import android.content.Context
import com.example.weatherForecastApp.presenter.currentWeatherPresenter.CurrentWeatherDataBinder
import com.example.weatherForecastApp.presenter.dailyForecastPresenter.DailyForecastDataBinder
import com.example.weatherForecastApp.presenter.hourlyForecastPresenter.HourlyForecastDataBinder
import com.example.weatherForecastApp.presenter.util.IconWeatherBinder
import com.example.weatherForecastApp.presenter.util.UserLocationFinder
import com.example.weatherForecastApp.ui.userLocation.UserLocation
import com.example.weatherForecastApp.weather.WeatherModelStubImpl
import com.example.weatherForecastApp.weather.repository.HttpRequestExecutor
import com.example.weatherForecastApp.weather.util.WeatherJSONParser


class DependencyRoot(context: Context) {
    private val weatherJSONParser = WeatherJSONParser()
    private val remoteRequestMaker = HttpRequestExecutor()
//    val weatherModel = WeatherModelImpl(weatherJSONParser, remoteRequestMaker)
    val weatherModel = WeatherModelStubImpl()
    private val iconBinder = IconWeatherBinder()
    val currentWeatherDataBinder = CurrentWeatherDataBinder(iconBinder)
    val hourlyForecastDataBinder = HourlyForecastDataBinder(iconBinder)
    val dailyWeatherDataBinder = DailyForecastDataBinder(iconBinder)
    val userLocation = UserLocation()
    val locationFinder = UserLocationFinder(context, userLocation)
}