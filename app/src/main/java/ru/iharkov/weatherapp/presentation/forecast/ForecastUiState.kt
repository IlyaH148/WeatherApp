package ru.iharkov.weatherapp.presentation.forecast

sealed interface ForecastUiState {

    data object Loading : ForecastUiState

    data class Content(
        val forecast: List<ForecastDay>
    ) : ForecastUiState

    data class Error(
        val message: String
    ) : ForecastUiState
}