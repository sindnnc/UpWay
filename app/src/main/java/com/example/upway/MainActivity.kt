package com.example.upway

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.component.theme.UpWayTheme
import com.example.features.navigation.UpWayApplication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            UpWayTheme {
                UpWayApplication()
            }
        }
        val sharedPref = this.getSharedPreferences(
            getString(R.string.app_name), Context.MODE_PRIVATE
        )
    }
}

