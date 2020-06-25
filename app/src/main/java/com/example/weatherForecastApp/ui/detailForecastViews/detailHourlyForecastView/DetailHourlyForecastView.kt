package com.example.weatherForecastApp.ui.detailForecastViews.detailHourlyForecastView

import com.example.weatherForecastApp.presenter.row.HourForecastRow
import com.example.weatherForecastApp.ui.WeatherView

interface DetailHourlyForecastView: WeatherView {
    fun bindData(hourlyForecastRow: List<HourForecastRow>?)
}