package com.example.weatherForecastApp.presenter.hourlyForecastPresenter

import androidx.lifecycle.MutableLiveData
import com.example.weatherForecastApp.presenter.WeatherPresenter
import com.example.weatherForecastApp.presenter.row.HourForecastRow

interface HourlyForecastPresenter: WeatherPresenter {
    fun getLiveData(): MutableLiveData<List<HourForecastRow>>
}