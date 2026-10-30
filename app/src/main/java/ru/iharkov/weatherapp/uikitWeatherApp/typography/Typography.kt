package ru.iharkov.weatherapp.uikitWeatherApp.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.iharkov.weatherapp.R

class WATypography(

    val titleSemiBold30: TextStyle,
    val titleMedium70: TextStyle,

    val errorSemiBold30: TextStyle,
    val errorMedium16: TextStyle,

    val headlineSemiBold12: TextStyle,
    val headlineMedium15: TextStyle,

    val captionSemiBold14: TextStyle,
    val captionSemiBold20: TextStyle,

    val labelSemiBold14: TextStyle,
    val labelMedium12: TextStyle
)

val Montserrat = FontFamily(
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_medium, FontWeight.Medium),

)
val Roboto = FontFamily(
    Font(R.font.roboto_semibold, FontWeight.SemiBold),
    Font(R.font.roboto_medium, FontWeight.Medium)
)

val WeatherTypography: WATypography
    @Composable
    get() {
        return WATypography(
            titleSemiBold30 = TextStyle(
                fontSize = 30.sp,
                lineHeight = 30.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            ),
            titleMedium70 = TextStyle(
                fontSize = 70.sp,
                lineHeight = 70.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Medium
            ),
            errorSemiBold30 = TextStyle(
                fontSize = 30.sp,
                lineHeight = 30.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            ),
            errorMedium16 = TextStyle(
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Medium
            ),
            headlineSemiBold12 = TextStyle(
                fontSize = 12.sp,
                lineHeight = 30.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            ),
            headlineMedium15 = TextStyle(
                fontSize = 15.sp,
                lineHeight = 15.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Medium
            ),
            captionSemiBold14 = TextStyle(
                fontSize = 14.sp,
                lineHeight = 14.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight.SemiBold
            ),
            captionSemiBold20 = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 4.sp ,
                fontFamily = Roboto,
                fontWeight = FontWeight.SemiBold
            ),
            labelSemiBold14 = TextStyle(
                fontSize = 14.sp,
                lineHeight = 14.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight.SemiBold
            ),
            labelMedium12 = TextStyle(
                fontSize = 12.sp,
                lineHeight = 12.sp,
                fontFamily = Roboto,
                fontWeight = FontWeight.Medium
            )
        )
    }