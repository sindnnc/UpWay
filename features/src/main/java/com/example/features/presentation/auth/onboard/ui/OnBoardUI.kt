package com.example.features.presentation.auth.onboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.component.button.AuthButton
import com.example.component.text.ButtonText
import com.example.component.theme.Blue
import com.example.component.theme.Red
import com.example.component.theme.Yellow
import com.example.features.R
import com.example.features.navigation.Screens
import kotlinx.coroutines.coroutineScope

@Composable
fun OnBoardUI(
    navController: NavController,
    screenHeight: Dp,
    screenWidth: Dp
) {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier.weight(1.2F).fillMaxSize().background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            Text(stringResource(id = R.string.app_name), fontSize = 40.sp)
        }
        Column(
            modifier = Modifier.weight(1F).fillMaxSize().padding(horizontal = screenWidth * 0.04F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            AuthButton(color = Yellow.p700, height = screenHeight, onClick = {}) {
                ButtonText(text = R.string.create_account_text)
            }
            AuthButton(color = MaterialTheme.colors.surface, height = screenHeight,
                onClick = {
                    navController.navigate(Screens.LoginUI.route)
                }
            ) {
                ButtonText(R.string.login_email_text)
            }
            AuthButton(color = Red.p400, height = screenHeight, onClick = {}) {
                ButtonText(R.string.login_google_text)
            }
            AuthButton(color = Blue.p500, height = screenHeight, onClick = {}) {
                ButtonText(text = R.string.login_facebook_text)
            }
        }
        Box(
            modifier = Modifier.weight(1F).fillMaxSize()
        ) {
        }
    }
}