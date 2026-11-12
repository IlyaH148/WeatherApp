package ru.iharkov.weatherapp.data.repository.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.iharkov.weatherapp.data.repository.remote.dto.WeatherResponseDto

interface WeatherApi{
    @GET("VisualCrossingWebServices/rest/services/timeline/{latitude},{longitude}/next10days")
    suspend fun getForecast(
        @Path("latitude")  latitude: Double,
        @Path("longitude")  longitude: Double,
        @Query("key")  apiKey: String,
        @Query("unitGroup")  unitGroup: String = "metric",
        @Query("include")  include: String = "days,current",
        @Query("contentType")  contentType: String = "json",
        ): WeatherResponseDto
}