package com.example.weatherForecastApp.ui.mainViews.hourlyForecastView

import com.example.weatherForecastApp.presenter.row.HourForecastRow
import com.example.weatherForecastApp.ui.WeatherView

interface HourlyForecastView: WeatherView {
    fun bindData(hourlyForecastRow: List<HourForecastRow>?)

    interface Listener {
        fun onHourlyAdapterItemClick(hourlyForecastRow: ArrayList<HourForecastRow>)
    }
}