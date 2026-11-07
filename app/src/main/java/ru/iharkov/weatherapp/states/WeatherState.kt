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
    ),
    FOG(
        icon = R.drawable.ic_fog,
        title = R.string.weather_fog
    ),
    HEAVE_SLEET(
        icon = R.drawable.ic_heave_sleet,
        title = R.string.weather_heave_sleet
    ),
    HEAVE_SLEET_SNOW_SHOWER(
        icon = R.drawable.ic_heave_sleet_snow_shower,
        title = R.string.weather_heave_sleet_snow_shower
    ),
    HEAVE_SNOW(
        icon = R.drawable.ic_heave_snow,
        title = R.string.weather_heave_snow
    ),
    OVERCAST(
        icon = R.drawable.ic_overcast,
        title = R.string.weather_overcast
    ),
    PARTY_CLOUDY(
        icon = R.drawable.ic_party_cloudy,
        title = R.string.weather_party_cloudy
    ),
    SMALL_RAIN(
        icon = R.drawable.ic_small_rain,
        title = R.string.weather_small_rain
    ),
    SNOWY(
        icon = R.drawable.ic_snowy,
        title = R.string.weather_snowy
    ),
    SNOWY_SHOWER(
        icon = R.drawable.ic_snowy_shower,
        title = R.string.weather_snowy_shower
    ),
    THUNDERSTORM_SHOWERS(
        icon = R.drawable.ic_thundershtorm_showers,
        title = R.string.weather_thunderstorm_showers
    ),
    WINDY(
        icon = R.drawable.ic_windy,
        title = R.string.weather_windy
    )
}