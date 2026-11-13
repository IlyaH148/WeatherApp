package ru.iharkov.weatherapp.data.repository.local


import androidx.room.Database
import androidx.room.RoomDatabase
import ru.iharkov.weatherapp.data.repository.local.entity.ForecastEntity
import ru.iharkov.weatherapp.data.repository.local.entity.WeatherEntity

@Database(entities = [WeatherEntity::class, ForecastEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase(){
    abstract fun weatherDao(): WeatherDao
}
