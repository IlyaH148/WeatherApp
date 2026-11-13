package ru.iharkov.weatherapp.data.repository.mapper

import ru.iharkov.weatherapp.data.repository.local.entity.ForecastEntity
import ru.iharkov.weatherapp.data.repository.local.entity.WeatherEntity
import ru.iharkov.weatherapp.domain.model.Forecast
import ru.iharkov.weatherapp.domain.model.Weather
import ru.iharkov.weatherapp.domain.model.WeatherCondition
import java.time.LocalDate
import java.time.LocalTime


fun mapWeatherToWeatherEntity(weather: Weather, savedAt: Long): WeatherEntity{
    return WeatherEntity(
        time = weather.time.toString(),
        temperature = weather.temperature,
        weatherCondition = weather.weatherCondition.name,
        windSpeed = weather.windSpeed,
        pressure = weather.pressure,
        humidity = weather.humidity,
        savedAt = savedAt
    )
}


fun mapWeatherEntityToWeather(weatherEntity: WeatherEntity): Weather{
    return Weather(
        time = LocalTime.parse(weatherEntity.time),
        temperature = weatherEntity.temperature,
        weatherCondition = WeatherCondition.valueOf(weatherEntity.weatherCondition),
        windSpeed = weatherEntity.windSpeed,
        pressure = weatherEntity.pressure,
        humidity = weatherEntity.humidity,
    )
}


fun mapForecastToForecastEntity(forecast: Forecast, savedAt: Long): ForecastEntity{
    return ForecastEntity(
        date = forecast.date.toString(),
        temperature = forecast.temperature,
        weatherCondition = forecast.weatherCondition.name,
        savedAt = savedAt
    )
}


fun mapForecastEntityToForecast(forecastEntity: ForecastEntity): Forecast{
    return Forecast(
        weatherCondition = WeatherCondition.valueOf(forecastEntity.weatherCondition),
        date = LocalDate.parse(forecastEntity.date),
        temperature = forecastEntity.temperature,
    )
}

