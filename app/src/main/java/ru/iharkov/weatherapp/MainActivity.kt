package ru.iharkov.weatherapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import ru.iharkov.weatherapp.Screens.CurrentWeather
import ru.iharkov.weatherapp.Screens.Forecast
import ru.iharkov.weatherapp.Screens.LoadingScreen
import ru.iharkov.weatherapp.States.WeatherState
import ru.iharkov.weatherapp.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val controller = rememberNavController()
            AppNavHost(
                navHostController = controller
            )
        }
    }
}


