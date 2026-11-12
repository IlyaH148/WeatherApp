package ru.iharkov.weatherapp.data.repository.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val weatherApi: WeatherApi = Retrofit.Builder()
        .baseUrl("https://weather.visualcrossing.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)
}