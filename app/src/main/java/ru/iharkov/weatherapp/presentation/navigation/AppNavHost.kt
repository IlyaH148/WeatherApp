package ru.iharkov.weatherapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.iharkov.weatherapp.domain.repository.WeatherRepository
import ru.iharkov.weatherapp.screens.CurrentWeather
import ru.iharkov.weatherapp.screens.Forecast

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    repository: WeatherRepository
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val screenFirstState: Boolean = currentRoute == Destination.First.route
    val screenSecondState: Boolean = currentRoute == Destination.Second.route

    NavHost(
        navController = navHostController, startDestination = Destination.First.route,
    ) {
        composable(route = Destination.First.route) {
            CurrentWeather(
                onNextClick = {
                    navHostController.navigate(Destination.Second.route)
                },
                screen = screenFirstState,
                repository
            )
        }

        composable(route = Destination.Second.route) {
            Forecast(
                onBackClick = {
                    navHostController.popBackStack()
                },
                screen = screenSecondState,
                repository
            )
        }
    }
}