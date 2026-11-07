package ru.iharkov.weatherapp.presentation.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.iharkov.weatherapp.domain.repository.WeatherRepository
import ru.iharkov.weatherapp.presentation.currentweather.mapForecastToUi

class ForecastViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ForecastUiState>(
        value = ForecastUiState.Loading
    )
    val uiState = _uiState.asStateFlow()


    fun loadForecast() {
        _uiState.value = ForecastUiState.Loading
        viewModelScope.launch {
            delay(1500)
            try {
                val forecast = repository.getForecast()
                val forecastUiModel = forecast.map { day ->
                    mapForecastToUi(day)
                }
                _uiState.value = ForecastUiState.Content(forecastUiModel)
            } catch (e: Exception) {
                _uiState.value = ForecastUiState.Error(e.message ?: "Ошибко")
            }
        }
    }

}
