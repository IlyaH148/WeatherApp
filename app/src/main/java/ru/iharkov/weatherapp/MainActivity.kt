package ru.iharkov.weatherapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import ru.iharkov.weatherapp.data.repository.FakeWeatherRepository
import ru.iharkov.weatherapp.presentation.navigation.AppNavHost
import ru.iharkov.weatherapp.ui.theme.WeatherAppTheme

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


