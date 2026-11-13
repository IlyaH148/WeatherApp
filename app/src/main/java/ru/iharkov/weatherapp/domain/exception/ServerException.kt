package ru.iharkov.weatherapp.domain.exception

class ServerException(
    val code: Int
) : Exception() {

}