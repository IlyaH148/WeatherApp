package ru.iharkov.weatherapp.data.repository.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.iharkov.weatherapp.data.repository.local.entity.ForecastEntity
import ru.iharkov.weatherapp.data.repository.local.entity.WeatherEntity

@Dao
interface WeatherDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Query("SELECT * FROM weather")
    suspend fun getWeather(): WeatherEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(forecast: List<ForecastEntity>)

    @Query("SELECT * FROM forecast ORDER BY date")
    suspend fun getForecast(): List<ForecastEntity>

    @Query("DELETE FROM forecast")
    suspend fun clear()
}