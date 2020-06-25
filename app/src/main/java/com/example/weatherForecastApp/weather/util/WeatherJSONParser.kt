package com.example.weatherForecastApp.weather.util

import com.example.weatherForecastApp.*
import com.example.weatherForecastApp.weather.model.CurrentWeather
import com.example.weatherForecastApp.weather.model.DayForecast
import com.example.weatherForecastApp.weather.model.HourForecast
import com.example.weatherForecastApp.weather.model.Weather
import org.json.JSONObject

class WeatherJSONParser {

    fun parseCurrentWeather(jsonWeather: JSONObject): CurrentWeather {
        val weather = parseWeather(jsonWeather.getJSONObject(PARSER_KEY_WEATHER))
        val pod = jsonWeather.getString(PARSER_KEY_POD)
        val temp = jsonWeather.getDouble(PARSER_KEY_TEMP)
        val feelLike = jsonWeather.getDouble(PARSER_KEY_FEEL_LIKE)
        val pressure = jsonWeather.getDouble(PARSER_KEY_PRESSURE)
        val humidity = jsonWeather.getDouble(PARSER_KEY_HUMIDITY)
        val windSpeed = jsonWeather.getDouble(PARSER_KEY_WIND_SPEED)
        val windDir = jsonWeather.getString(PARSER_KEY_WIND_DIR)
        val uvIndex = jsonWeather.getInt(PARSER_KEY_UV_INDEX)
        val visibility = jsonWeather.getInt(PARSER_KEY_VISIBILITY)
        val dewPoint = jsonWeather.getDouble(PARSER_KEY_DEW_POINT)
        return CurrentWeather(
            weather,
            pod,
            temp,
            feelLike,
            pressure,
            humidity,
            windSpeed,
            windDir,
            uvIndex,
            visibility,
            dewPoint
        )
    }

    fun parseHourlyWeather(jsonWeather: JSONObject): ArrayList<HourForecast> {
        val hourForecasts = ArrayList<HourForecast>()
        val hourlyForecastsJSON = jsonWeather.getJSONArray(PARSER_KEY_LIST)
        for (i in 0 until hourlyForecastsJSON.length()) {
            val hourlyForecastJSON = hourlyForecastsJSON.getJSONObject(i)
            val weather =
                parseWeather(hourlyForecastJSON.getJSONObject(PARSER_KEY_WEATHER))
            val pod = hourlyForecastJSON.getString(PARSER_KEY_POD)
            val date = hourlyForecastJSON.getLong(PARSER_KEY_DATE)
            val temp = hourlyForecastJSON.getDouble(PARSER_KEY_TEMP)
            val feelLike = hourlyForecastJSON.getDouble(PARSER_KEY_FEEL_LIKE)
            val pressure = hourlyForecastJSON.getDouble(PARSER_KEY_PRESSURE)
            val humidity = hourlyForecastJSON.getDouble(PARSER_KEY_HUMIDITY)
            val windSpeed = hourlyForecastJSON.getDouble(PARSER_KEY_WIND_SPEED)
            val oneHourForecast =
                HourForecast(weather, pod, date, temp, feelLike, pressure, humidity, windSpeed)
            hourForecasts.add(oneHourForecast)
        }
        return hourForecasts
    }

    fun parseDailyWeather(jsonWeather: JSONObject): ArrayList<DayForecast> {
        val dailyForecast = ArrayList<DayForecast>()
        val dailyForecastJSON = jsonWeather.getJSONArray(PARSER_KEY_LIST)
        for (i in 0 until dailyForecastJSON.length()) {
            val oneDayForecastJSON = dailyForecastJSON.getJSONObject(i)
            val weather =
                parseWeather(oneDayForecastJSON.getJSONObject(PARSER_KEY_WEATHER))
            val date = oneDayForecastJSON.getLong(PARSER_KEY_DATE)
            val maxTemp = oneDayForecastJSON.getDouble(PARSER_KEY_MAX_TEMP)
            val minTemp = oneDayForecastJSON.getDouble(PARSER_KEY_MIN_TEMP)
            val maxTempFeelLike = oneDayForecastJSON.getDouble(PARSER_KEY_FEEL_LIKE_MAX_TEMP)
            val minTempFeelLike = oneDayForecastJSON.getDouble(PARSER_KEY_FEEL_LIKE_MIX_TEMP)
            val pressure = oneDayForecastJSON.getDouble(PARSER_KEY_PRESSURE)
            val humidity = oneDayForecastJSON.getDouble(PARSER_KEY_HUMIDITY)
            val windSpeed = oneDayForecastJSON.getDouble(PARSER_KEY_WIND_SPEED)
            val windDir = oneDayForecastJSON.getString(PARSER_KEY_WIND_DIR)
            val pop = oneDayForecastJSON.getInt(PARSER_KEY_POP)
            val oneDayForecast = DayForecast(
                weather,
                date,
                maxTemp,
                minTemp,
                maxTempFeelLike,
                minTempFeelLike,
                pressure,
                humidity,
                windSpeed,
                windDir,
                pop
            )
            dailyForecast.add(oneDayForecast)
        }
        return dailyForecast
    }

    private fun parseWeather(weather: JSONObject): Weather {
        return Weather(weather.getInt(PARSER_KEY_CODE), weather.getString(PARSER_KEY_DESCRIPTION))
    }
}