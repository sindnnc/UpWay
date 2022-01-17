package com.example.features.auth.login.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.component.textfield.AuthTextField
import com.example.component.view.ColumnContainer
import com.example.features.R
import com.example.features.auth.login.viewmodel.LoginViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginUI(
    navController: NavController,
    viewModel: LoginViewModel,
    screenHeight: Dp,
    screenWidth: Dp
) {

    ColumnContainer
    {
        Box(modifier = Modifier.weight(1F, true), contentAlignment = Alignment.CenterStart) {
            Text(
                text = "Welcome Back",
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace,
                fontSize = 30.sp
            )
        }
        ColumnContainer(
            modifier = Modifier
                .weight(2F, true)
                .padding(horizontal = screenWidth * 0.1F),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            val email = mutableStateOf("")

            AuthTextField(value = email, label = R.string.app_name)
        }
        Row(
            modifier = Modifier
                .weight(1.5F, true)
                .background(Color.Yellow)
        ) {

        }
    }
}