package ru.iharkov.weatherapp.data.repository.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.iharkov.weatherapp.data.repository.remote.dto.WeatherResponseDto

interface WeatherApi{
    @GET("v1/forecast")
    suspend fun getForecast(
        @Query("latitude")  latitude: Double,
        @Query("longitude")  longitude: Double,
        @Query("current")  current: String = "temperature_2m,relative_humidity_2m,surface_pressure,wind_speed_10m,weather_code",
        @Query("daily")  daily: String = "weather_code,temperature_2m_max",
        @Query("forecast_days")  forecastDays: Int = 10,
        @Query("timezone")  timezone: String = "Europe/Samara",
        @Query("wind_speed_unit")  windSpeedUnit: String = "ms",
        ): WeatherResponseDto
}