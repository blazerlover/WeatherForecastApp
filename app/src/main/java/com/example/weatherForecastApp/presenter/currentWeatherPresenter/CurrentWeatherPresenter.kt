package com.example.weatherForecastApp.presenter.currentWeatherPresenter

import androidx.lifecycle.MutableLiveData
import com.example.weatherForecastApp.presenter.WeatherPresenter
import com.example.weatherForecastApp.presenter.row.CurrentWeatherRow

interface CurrentWeatherPresenter: WeatherPresenter {
    fun getLiveData(): MutableLiveData<CurrentWeatherRow>
}