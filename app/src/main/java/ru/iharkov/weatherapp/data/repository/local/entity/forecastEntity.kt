package ru.iharkov.weatherapp.data.repository.local.entity

import android.health.connect.datatypes.units.Temperature
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import ru.iharkov.weatherapp.domain.model.WeatherCondition


@Entity(tableName = "forecast")
data class ForecastEntity(
    @PrimaryKey val date: String,
    val temperature: Int,
    val weatherCondition: String,
    val savedAt: Long,
)