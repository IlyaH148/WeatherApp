package ru.iharkov.weatherapp.presentation.common.mapper

import NoInternetException
import ru.iharkov.weatherapp.domain.exception.ServerException

fun mapErrorToMessage(
    error: Exception
): String{
    return when(error){
        is NoInternetException -> "Отсутствует подключение к интернету"
        is ServerException -> when(error.code){
            400,401 -> "Проблема с доступом"
            429 -> "Превышен лимит запросов"
            404 -> "Не найден ресурс"
            else -> "Код ошибки: ${error.code}"
        }
        else -> "Неизвестная ошибка"
    }
}