package ru.iharkov.weatherapp.data.repository.local.entity

import android.health.connect.datatypes.units.Temperature
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.iharkov.weatherapp.domain.model.WeatherCondition


@Entity(tableName = "forecast")
data class ForecastEntity(
    @PrimaryKey val date: String,
    val temperature: Int,
    val weatherCondition: String,
    val savedAt: Long,
)