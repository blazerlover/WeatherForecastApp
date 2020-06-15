package com.example.uxweatherkt.presenter.row

import android.os.Parcel
import android.os.Parcelable

class HourForecastRow : Parcelable {

    var date: String?
    var temp: String?
    var feelLike: String?
    var pressure: String?
    var humidity: String?
    var windSpeed: String?
    var weatherDescription: String?
    var iconId: Int

    constructor(
        date: String,
        temp: String,
        feelLike: String,
        pressure: String,
        humidity: String,
        windSpeed: String,
        weatherDescription: String?,
        iconId: Int
    ) {
        this.date = date
        this.temp = temp
        this.feelLike = feelLike
        this.pressure = pressure
        this.humidity = humidity
        this.windSpeed = windSpeed
        this.weatherDescription = weatherDescription
        this.iconId = iconId
    }

    private constructor(parcel: Parcel) {
        val array = arrayOfNulls<String>(7)
        parcel.readStringArray(array)
        date = array[0]
        temp = array[1]
        feelLike = array[2]
        pressure = array[3]
        humidity = array[4]
        windSpeed = array[5]
        weatherDescription = array[6]
        iconId = parcel.readInt()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeStringArray(
            arrayOf(
                date, temp, feelLike, pressure, humidity, windSpeed, weatherDescription
            )
        )
        dest?.writeInt(iconId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HourForecastRow> {
        override fun createFromParcel(parcel: Parcel): HourForecastRow {
            return HourForecastRow(parcel)
        }

        override fun newArray(size: Int): Array<HourForecastRow?> {
            return arrayOfNulls(size)
        }

    }
}

