package com.example.weatherForecastApp.ui.mainViews.dailyForecastView

import com.example.weatherForecastApp.presenter.row.DayForecastRow
import com.example.weatherForecastApp.ui.WeatherView

interface DailyForecastView: WeatherView {
    fun bindData(dailyForecastRow: List<DayForecastRow>?)

    interface Listener {
        fun onDailyAdapterItemClick(dailyForecastRow: ArrayList<DayForecastRow>)
    }
}