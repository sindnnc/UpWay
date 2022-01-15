package com.example.component.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Grey.p100,
    primaryVariant = Grey.p300,
    secondary = Grey.p500,
)

private val LightColorPalette = lightColors(
    primary = Blue.p300,
    primaryVariant = Blue.p500,
    secondary = Green.p100,
)


@Composable
fun UpWayTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = CustomMediumShapes,
        content = content
    )
}