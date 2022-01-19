package com.example.features.presentation.auth.login.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.component.button.AuthButton
import com.example.component.icon.CustomIconButton
import com.example.component.icon.LoginIconButton
import com.example.component.popUp.CustomPopUp
import com.example.component.text.ButtonSingleText
import com.example.component.text.HeaderText
import com.example.component.textfield.AuthTextField
import com.example.component.theme.Gray
import com.example.component.view.Container
import com.example.features.R
import com.example.features.extension.noRippleClickable
import com.example.features.navigation.Screens
import com.example.features.presentation.auth.login.viewmodel.LoginViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginUI(navController: NavController, viewModel: LoginViewModel, screenHeight: Dp, screenWidth: Dp) {
    val focusManager = LocalFocusManager.current
    val password = mutableStateOf("")
    val email = mutableStateOf("")
    val popUp = mutableStateOf(false)

    Container(alignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier.fillMaxSize().noRippleClickable {
                    if (popUp.value) popUp.value = false
                    focusManager.clearFocus()
                }.padding(horizontal = screenWidth * 0.08F, vertical = screenWidth * 0.03F),
            verticalArrangement = Arrangement.Center,
        ) {
            HeaderView(modifier = Modifier.weight(1.2F, true), navController = navController, popUp)
            BodyView(Modifier.weight(2F, true), email, password, screenHeight, popUp)
            BottomView(Modifier.fillMaxSize().weight(2F, true))
        }
        if (popUp.value) {
            CustomPopUp() {
            }
        }
    }
}


//HEADER VIEW
@Composable
private fun HeaderView(modifier: Modifier = Modifier, navController: NavController, popUp: MutableState<Boolean>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomIconButton(Icons.Default.ArrowBack) {
                navController.popBackStack(Screens.OnBoardUI.route, false)
            }
            CustomIconButton(Icons.Default.Settings) {
                popUp.value = !popUp.value
            }
        }
        HeaderText(R.string.welcome_text)
    }
}

//BODY VIEW
@Composable
private fun BodyView(
    modifier: Modifier = Modifier, email: MutableState<String>,
    password: MutableState<String>, screenHeight: Dp, popUp: MutableState<Boolean>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        //Email TextField
        AuthTextField(isEnabled = !popUp.value, value = email, label = R.string.email_text)
        //Password TextField
        AuthTextField(
            isEnabled = !popUp.value, value = password, label = R.string.password_text,
            isOverLineText = true, forgotPassword = R.string.forget_password_text
        )
        //Login Button
        AuthButton(height = screenHeight, onClick = {}) {
            ButtonSingleText(text = R.string.login_text)
        }
    }
}

//BOTTOM VIEW
@Composable
private fun BottomView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LoginIconButton(Icons.Default.LocationOn) {}
        LoginIconButton(Icons.Default.Face) {}
        LoginIconButton(Icons.Default.Warning) {}
        LoginIconButton(Icons.Default.Warning) {}
    }
}
