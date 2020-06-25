package com.example.weatherForecastApp.ui.detailForecastViews.detailHourlyForecastView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherForecastApp.R
import com.example.weatherForecastApp.presenter.row.HourForecastRow

class DetailHourlyForecastAdapter : RecyclerView.Adapter<DetailHourlyForecastAdapter.ViewHolder>() {

    private var hourlyForecastRow = ArrayList<HourForecastRow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_detail_hourly_forecast, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hourlyForecastRow.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hourForecastRow = hourlyForecastRow[position]
        holder.ivWeather.setImageResource(hourForecastRow.iconId)
        holder.tvTime.text = hourForecastRow.date
        holder.tvTemp.text = tempNowAndFeelsLikeConcat(hourForecastRow)
        holder.tvWeather.text = hourForecastRow.weatherDescription
        holder.tvWind.text = windConcat(hourForecastRow)
        holder.tvPressure.text = pressureConcat(hourForecastRow)
        holder.tvHumidity.text = humidityConcat(hourForecastRow)
    }

    fun setDetailDailyForecast(hourlyForecastRow: List<HourForecastRow>) {
        this.hourlyForecastRow.clear()
        this.hourlyForecastRow.addAll(hourlyForecastRow)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivWeather: ImageView = itemView.findViewById(R.id.row_detail_hourly_forecast__ivWeather)
        val tvTime: TextView = itemView.findViewById(R.id.row_detail_hourly_forecast__tvTime)
        val tvTemp: TextView = itemView.findViewById(R.id.row_detail_hourly_forecast__tvTemp)
        val tvWeather: TextView = itemView.findViewById(R.id.row_detail_hourly_forecast__tvWeather)
        val tvWind: TextView =
            itemView.findViewById(R.id.row_detail_hourly_forecast__tvWind)
        val tvPressure: TextView =
            itemView.findViewById(R.id.row_detail_hourly_forecast__tvPressure)
        val tvHumidity: TextView =
            itemView.findViewById(R.id.row_detail_hourly_forecast__tvHumidity)
    }

    private fun tempNowAndFeelsLikeConcat(hourForecastRow: HourForecastRow): String {
        return hourForecastRow.temp + " - Feels Like: " + hourForecastRow.feelLike
    }

    private fun windConcat(hourForecastRow: HourForecastRow): String {
        return "Wind: " + hourForecastRow.windSpeed
    }

    private fun pressureConcat(hourForecastRow: HourForecastRow): String {
        return "Pressure: " + hourForecastRow.pressure
    }

    private fun humidityConcat(hourForecastRow: HourForecastRow): String {
        return "Humidity: " + hourForecastRow.humidity
    }
}
