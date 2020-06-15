package com.example.uxweatherkt.ui.detailForecastViews.detailHourlyForecastView

import com.example.uxweatherkt.presenter.row.HourForecastRow
import com.example.uxweatherkt.ui.WeatherView

interface DetailHourlyForecastView: WeatherView {
    fun bindData(hourlyForecastRow: List<HourForecastRow>?)
}