package com.example.weatherForecastApp.ui.detailForecastViews.detailHourlyForecastView

import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherForecastApp.R
import com.example.weatherForecastApp.presenter.row.HourForecastRow
import com.example.weatherForecastApp.ui.baseView.BaseView

class DetailHourlyForecastViewImpl : BaseView, DetailHourlyForecastView {

    constructor(
        baseRootView: View
    ) {
        this.baseRootView = baseRootView
        init()
    }

    private lateinit var detailHourlyForecastAdapter: DetailHourlyForecastAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var pbLoading: ProgressBar

    override fun bindData(hourlyForecastRow: List<HourForecastRow>?) {
        hideLoading()
        if (hourlyForecastRow == null) {
            return
        }
        initData(hourlyForecastRow)
    }

    private fun initData(hourlyForecastRows: List<HourForecastRow>) {
        detailHourlyForecastAdapter.setDetailDailyForecast(hourlyForecastRows)
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
        baseRootView.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.GONE
        baseRootView.visibility = View.VISIBLE
    }

    private fun init() {
        detailHourlyForecastAdapter = DetailHourlyForecastAdapter()
        val linearLayoutManager =
            LinearLayoutManager(baseRootView.context, RecyclerView.VERTICAL, false)
        recyclerView = baseRootView.findViewById(R.id.fragment_detail__rvDetailWeather)
        recyclerView.adapter = detailHourlyForecastAdapter
        recyclerView.layoutManager = linearLayoutManager
        pbLoading = baseRootView.findViewById(R.id.fragment_detail__pbLoading)
    }
}