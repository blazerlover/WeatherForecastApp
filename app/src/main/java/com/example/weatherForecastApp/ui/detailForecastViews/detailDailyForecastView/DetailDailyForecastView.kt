package com.example.weatherForecastApp.ui.detailForecastViews.detailDailyForecastView

import com.example.weatherForecastApp.presenter.row.DayForecastRow
import com.example.weatherForecastApp.ui.WeatherView

interface DetailDailyForecastView: WeatherView {
    fun bindData(dailyForecastRow: List<DayForecastRow>?)
}