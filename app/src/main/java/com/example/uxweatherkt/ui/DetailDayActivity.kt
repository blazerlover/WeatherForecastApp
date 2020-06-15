package com.example.uxweatherkt.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uxweatherkt.*
import com.example.uxweatherkt.presenter.row.DayForecastRow
import com.example.uxweatherkt.presenter.row.HourForecastRow


class DetailDayActivity : AppCompatActivity() {

    object StartObj {
        fun startWithDailyForecast(context: Context, dailyForecastRow: ArrayList<DayForecastRow>) {
            val intent = Intent(context, DetailDayActivity::class.java)
            intent.putExtra(INTENT_ID, 0)
            intent.putExtra(DAILY_FORECAST_ROW_KEY, dailyForecastRow)
            context.startActivity(intent)
        }

        fun startWithHourlyForecast(context: Context, hourlyForecastRow: ArrayList<HourForecastRow>) {
            val intent = Intent(context, DetailDayActivity::class.java)
            intent.putExtra(INTENT_ID, 1)
            intent.putExtra(HOURLY_FORECAST_ROW_KEY, hourlyForecastRow)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_day)
        initDetailFragment(savedInstanceState)
    }

    private fun initDetailFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.activity_detail_day__fragment_container,
                    DetailFragment(),
                    DETAIL_FRAGMENT_TAG
                )
                .commit()
        }
    }
}
