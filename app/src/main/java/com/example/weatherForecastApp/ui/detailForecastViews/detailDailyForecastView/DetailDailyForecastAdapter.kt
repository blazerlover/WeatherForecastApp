package com.example.weatherForecastApp.ui.detailForecastViews.detailDailyForecastView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherForecastApp.MS
import com.example.weatherForecastApp.R
import com.example.weatherForecastApp.presenter.row.DayForecastRow

class DetailDailyForecastAdapter : RecyclerView.Adapter<DetailDailyForecastAdapter.ViewHolder>() {

    private var dailyForecastRow = ArrayList<DayForecastRow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_detail_daily_forecast, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return dailyForecastRow.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dayForecastRow = dailyForecastRow[position]
        holder.ivWeather.setImageResource(dayForecastRow.iconId)
        holder.tvDate.text = dayForecastRow.date
        holder.tvTemp.text = tempMinMaxConcat(dayForecastRow)
        holder.tvDayForecast.text = dayForecastConcat(dayForecastRow)
        holder.tvNightForecast.text = nightForecastConcat(dayForecastRow)
    }

    fun setDetailDailyForecast(dailyForecastRow: List<DayForecastRow>) {
        this.dailyForecastRow.clear()
        this.dailyForecastRow.addAll(dailyForecastRow)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivWeather: ImageView = itemView.findViewById(R.id.row_detail_daily_forecast__ivWeather)
        val tvDate: TextView = itemView.findViewById(R.id.row_detail_daily_forecast__tvDate)
        val tvTemp: TextView = itemView.findViewById(R.id.row_detail_daily_forecast__tvTemp)
        val tvDayForecast: TextView =
            itemView.findViewById(R.id.row_detail_daily_forecast__tvWind)
        val tvNightForecast: TextView =
            itemView.findViewById(R.id.row_detail_daily_forecast__tvNightForecast)
    }

    private fun tempMinMaxConcat(dayForecastRow: DayForecastRow): String {
        return dayForecastRow.maxTemp + "/" + dayForecastRow.minTemp
    }

    private fun dayForecastConcat(dayForecastRow: DayForecastRow): String {
        var pop = ""
        if (dayForecastRow.pop != "") {
            pop = "Chance of precipitation " + dayForecastRow.pop
        }
        return "Day " + dayForecastRow.weatherDescription + ". " +
                "High " + dayForecastRow.maxTemp + ". " +
                "Wind " + dayForecastRow.windDir + " at " + dayForecastRow.windSpeed + MS + ". " +
                pop
    }

    private fun nightForecastConcat(dayForecastRow: DayForecastRow): String {
        var pop = ""
        if (dayForecastRow.pop != "") {
            pop = "Chance of precipitation " + dayForecastRow.pop
        }
        return "Night " + dayForecastRow.weatherDescription + ". " +
                "Low " + dayForecastRow.minTemp + ". " +
                "Wind " + dayForecastRow.windDir + " at " + dayForecastRow.windSpeed + MS + ". " +
                pop
    }
}