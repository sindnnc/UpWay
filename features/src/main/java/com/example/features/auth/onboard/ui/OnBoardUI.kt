package com.example.features.auth.onboard.ui

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
import com.example.component.theme.Blue
import com.example.component.theme.Red
import com.example.component.theme.Yellow
import com.example.component.view.ColumnContainer
import com.example.features.R
import com.example.features.navigation.Screens

@Composable
fun OnBoardUI(
    navController: NavController,
    screenHeight: Dp,
    screenWidth: Dp
) {
    ColumnContainer(verticalArrangement = Arrangement.SpaceAround) {
        Box(
            modifier = Modifier
                .weight(1.5F)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                stringResource(id = R.string.app_name),
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp
            )
        }
        Column(
            modifier = Modifier
                .weight(1F)
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            AuthButton(text = R.string.create_account_text, color = Yellow.p700) {
            }
            AuthButton(text = R.string.login_email_text, color = MaterialTheme.colors.surface) {
                navController.navigate(Screens.LoginUI.route)
            }
            AuthButton(text = R.string.login_google_text, color = Red.p400) {
            }
            AuthButton(text = R.string.login_facebook_text, color = Blue.p500) {
            }
        }
        Box(
            modifier = Modifier
                .weight(1F)
                .fillMaxSize()
        ) {
        }
    }
}