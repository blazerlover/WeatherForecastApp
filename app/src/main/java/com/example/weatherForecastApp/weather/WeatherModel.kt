package com.example.weatherForecastApp.weather

import com.example.weatherForecastApp.presenter.util.Coordinates
import com.example.weatherForecastApp.weather.model.CurrentWeather
import com.example.weatherForecastApp.weather.model.DayForecast
import com.example.weatherForecastApp.weather.model.HourForecast

interface WeatherModel {
    fun loadCurrentWeatherBy(coordinates: Coordinates): CurrentWeather?

    fun loadCurrentWeatherBy(cityName: String): CurrentWeather?

    fun loadHourlyForecastBy(coordinates: Coordinates): ArrayList<HourForecast>?

    fun loadHourlyForecastBy(cityName: String): ArrayList<HourForecast>?

    fun loadDailyForecastBy(coordinates: Coordinates): ArrayList<DayForecast>?

    fun loadDailyForecastBy(cityName: String): ArrayList<DayForecast>?
}