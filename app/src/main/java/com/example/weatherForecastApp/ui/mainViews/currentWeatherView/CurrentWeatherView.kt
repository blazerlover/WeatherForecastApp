package com.example.weatherForecastApp.ui.mainViews.currentWeatherView

import com.example.weatherForecastApp.presenter.row.CurrentWeatherRow
import com.example.weatherForecastApp.ui.WeatherView

interface CurrentWeatherView: WeatherView {
    fun bindData(currentWeatherRow: CurrentWeatherRow?)
}