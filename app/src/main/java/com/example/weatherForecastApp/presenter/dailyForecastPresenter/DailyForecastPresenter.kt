package com.example.weatherForecastApp.presenter.dailyForecastPresenter

import androidx.lifecycle.MutableLiveData
import com.example.weatherForecastApp.presenter.WeatherPresenter
import com.example.weatherForecastApp.presenter.row.DayForecastRow

interface DailyForecastPresenter: WeatherPresenter {
    fun getLiveData(): MutableLiveData<List<DayForecastRow>>
}