package ru.iharkov.weatherapp.states

import ru.iharkov.weatherapp.R

enum class WeatherState(
   val icon: Int,
   val title: Int,
){
    DEFAULT(
        icon = R.drawable.ic_error,
        title = R.string.error,
    ),
    SUN(
        icon = R.drawable.ic_sun,
        title = R.string.weather_sun,
    ),
    CLOUDY(
        icon = R.drawable.ic_cloudy,
        title = R.string.weather_cloudy,
    ),
    RAINY(
        icon = R.drawable.ic_rainy,
        title = R.string.weather_rainy,
    )
}