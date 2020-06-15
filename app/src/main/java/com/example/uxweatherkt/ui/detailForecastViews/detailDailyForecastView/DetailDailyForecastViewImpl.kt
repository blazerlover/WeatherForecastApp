package com.example.uxweatherkt.ui.detailForecastViews.detailDailyForecastView

import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uxweatherkt.R
import com.example.uxweatherkt.presenter.row.DayForecastRow
import com.example.uxweatherkt.ui.baseView.BaseView

class DetailDailyForecastViewImpl: BaseView,
    DetailDailyForecastView {

    constructor(
        baseRootView: View
    ) {
        this.baseRootView = baseRootView
        init()
    }

    private lateinit var detailDailyForecastAdapter: DetailDailyForecastAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var pbLoading: ProgressBar

    override fun bindData(dailyForecastRow: List<DayForecastRow>?) {
        hideLoading()
        if (dailyForecastRow == null) {
            return
        }
        initData(dailyForecastRow)
    }

    private fun initData(dailyForecastRow: List<DayForecastRow>) {
        detailDailyForecastAdapter.setDetailDailyForecast(dailyForecastRow)
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
        detailDailyForecastAdapter =
            DetailDailyForecastAdapter()
        val linearLayoutManager = LinearLayoutManager(baseRootView.context, RecyclerView.VERTICAL, false)
        recyclerView = baseRootView.findViewById(R.id.fragment_detail__rvDetailWeather)
        recyclerView.adapter = detailDailyForecastAdapter
        recyclerView.layoutManager = linearLayoutManager
        pbLoading = baseRootView.findViewById(R.id.fragment_detail__pbLoading)
    }
}