package com.example.component.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Blue.p400,
    primaryVariant = Blue.p600,
    secondary = Green.p300,
    background = Gray.p1100 ,
    error = Red.p500,
    onBackground = Specified.White,
    onError = Specified.Black,
    onPrimary = Specified.Black,
    onSecondary = Specified.White,
    onSurface = Specified.White,
    secondaryVariant = Green.p500,
    surface = Specified.Black,
)

private val LightColorPalette = lightColors(
    primary = Blue.p400,
    primaryVariant = Blue.p600,
    secondary = Green.p300,
    background = Gray.p1100 ,
    error = Red.p500,
    onBackground = Specified.Black,
    onError = Specified.White,
    onPrimary = Specified.White,
    onSecondary = Specified.Black,
    onSurface = Specified.Black,
    secondaryVariant = Green.p500,
    surface = Specified.White
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
        typography = OpenSansTypography,
        shapes = CustomMediumShapes,
        content = content
    )
}