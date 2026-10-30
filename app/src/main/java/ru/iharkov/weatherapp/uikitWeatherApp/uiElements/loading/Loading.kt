package ru.iharkov.weatherapp.uikitWeatherApp.uiElements.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ru.iharkov.weatherapp.R

@Composable
fun Loading(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            contentDescription = "",
            painter = painterResource(R.drawable.ic_circular),
        )
    }
}