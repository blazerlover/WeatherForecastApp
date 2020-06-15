package com.example.uxweatherkt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uxweatherkt.DAILY_FORECAST_ROW_KEY
import com.example.uxweatherkt.HOURLY_FORECAST_ROW_KEY
import com.example.uxweatherkt.INTENT_ID

import com.example.uxweatherkt.R
import com.example.uxweatherkt.presenter.row.DayForecastRow
import com.example.uxweatherkt.presenter.row.HourForecastRow
import com.example.uxweatherkt.ui.detailForecastViews.detailDailyForecastView.DetailDailyForecastView
import com.example.uxweatherkt.ui.detailForecastViews.detailDailyForecastView.DetailDailyForecastViewImpl
import com.example.uxweatherkt.ui.detailForecastViews.detailHourlyForecastView.DetailHourlyForecastView
import com.example.uxweatherkt.ui.detailForecastViews.detailHourlyForecastView.DetailHourlyForecastViewImpl

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
