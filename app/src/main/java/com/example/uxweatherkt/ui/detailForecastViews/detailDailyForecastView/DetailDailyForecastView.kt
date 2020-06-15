package com.example.uxweatherkt.ui.detailForecastViews.detailDailyForecastView

import com.example.uxweatherkt.presenter.row.DayForecastRow
import com.example.uxweatherkt.ui.WeatherView

interface DetailDailyForecastView: WeatherView {
    fun bindData(dailyForecastRow: List<DayForecastRow>?)
}