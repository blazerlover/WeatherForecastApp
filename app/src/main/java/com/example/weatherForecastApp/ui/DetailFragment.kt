package com.example.weatherForecastApp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherForecastApp.DAILY_FORECAST_ROW_KEY
import com.example.weatherForecastApp.HOURLY_FORECAST_ROW_KEY
import com.example.weatherForecastApp.INTENT_ID

import com.example.weatherForecastApp.R
import com.example.weatherForecastApp.presenter.row.DayForecastRow
import com.example.weatherForecastApp.presenter.row.HourForecastRow
import com.example.weatherForecastApp.ui.detailForecastViews.detailDailyForecastView.DetailDailyForecastView
import com.example.weatherForecastApp.ui.detailForecastViews.detailDailyForecastView.DetailDailyForecastViewImpl
import com.example.weatherForecastApp.ui.detailForecastViews.detailHourlyForecastView.DetailHourlyForecastView
import com.example.weatherForecastApp.ui.detailForecastViews.detailHourlyForecastView.DetailHourlyForecastViewImpl

class DetailFragment : Fragment() {

    private lateinit var detailDailyForecastView: DetailDailyForecastView
    private lateinit var detailHourlyForecastView: DetailHourlyForecastView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        initViews(view)
        return view
    }

    private fun initViews(baseRootView: View) {
        when {
            checkIntentType() == 0 -> {
                val dayForecastRows = activity?.intent?.getSerializableExtra(
                    DAILY_FORECAST_ROW_KEY
                ) as ArrayList<DayForecastRow>
                detailDailyForecastView = DetailDailyForecastViewImpl(baseRootView)
                detailDailyForecastView.showLoading()
                detailDailyForecastView.bindData(dayForecastRows)
            }
            checkIntentType() == 1 -> {
                val hourForecastRow = activity?.intent?.getSerializableExtra(
                    HOURLY_FORECAST_ROW_KEY
                ) as ArrayList<HourForecastRow>
                detailHourlyForecastView = DetailHourlyForecastViewImpl(baseRootView)
                detailHourlyForecastView.showLoading()
                detailHourlyForecastView.bindData(hourForecastRow)
            }
            else -> return
        }
    }

    private fun checkIntentType(): Int? {
        return activity?.intent?.getIntExtra(INTENT_ID, 2)
    }
}
