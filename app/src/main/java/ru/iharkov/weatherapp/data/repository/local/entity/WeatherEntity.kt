package ru.iharkov.weatherapp.data.repository.local.entity

import android.health.connect.datatypes.units.Temperature
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey val id: Int = 0,
    val time: String,
    val temperature: Int,
    val weatherCondition: String,
    val windSpeed: Double,
    val pressure: Int,
    val humidity: Int,
    val savedAt: Long,
)