package ru.iharkov.weatherapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import ru.iharkov.weatherapp.data.repository.FakeWeatherRepository
import ru.iharkov.weatherapp.navigation.AppNavHost
import ru.iharkov.weatherapp.screens.LoadingScreen
import ru.iharkov.weatherapp.ui.theme.WeatherAppTheme
import ru.iharkov.weatherapp.uikitWeatherApp.uiElements.error.ErrorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repository = FakeWeatherRepository()
        setContent {
            WeatherAppTheme() {
                val controller = rememberNavController()
                AppNavHost(
                    navHostController = controller,
                    repository = repository
                )
            }
        }
    }
}


