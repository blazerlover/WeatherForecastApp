package com.example.weatherForecastApp.ui.mainViews.hourlyForecastView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherForecastApp.R
import com.example.weatherForecastApp.presenter.row.HourForecastRow


class HourlyForecastAdapter(var listener: Listener) : RecyclerView.Adapter<HourlyForecastAdapter.ViewHolder>() {

    interface Listener {
        fun onHourForecastClick(hourlyForecast: ArrayList<HourForecastRow>)
    }

    var hourlyForecastRow = ArrayList<HourForecastRow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_hour_forecast, parent, false) as CardView
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hourForecastRow = hourlyForecastRow[position]
        holder.tvDate.text = hourForecastRow.date
        holder.tvHumidity.text = hourForecastRow.humidity
        holder.tvTemp.text = hourForecastRow.temp
        holder.tvFeelLike.text = hourForecastRow.feelLike
        holder.ivWeather.setImageResource(hourForecastRow.iconId)
        holder.itemView.setOnClickListener { listener.onHourForecastClick(hourlyForecastRow) }
    }

    override fun getItemCount(): Int {
        return hourlyForecastRow.size
    }

    fun setDailyForecast(dailyForecastRow: ArrayList<HourForecastRow>) {
        this.hourlyForecastRow.clear()
        this.hourlyForecastRow.addAll(dailyForecastRow)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: CardView) : RecyclerView.ViewHolder(itemView) {
        val tvDate: TextView = itemView.findViewById(R.id.row_hour_forecast__tvDate)
        val tvHumidity: TextView = itemView.findViewById(R.id.row_hour_forecast__tvHumidity)
        val tvTemp: TextView = itemView.findViewById(R.id.row_hour_forecast__tvTemp)
        val tvFeelLike: TextView = itemView.findViewById(R.id.row_hour_forecast__tvFeelLike)
        val ivWeather: ImageView = itemView.findViewById(R.id.row_hour_forecast__ivWeather)

    }
}