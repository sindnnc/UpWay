package com.example.component.textfield

import androidx.compose.foundation.border
import androidx.compose.material.OutlinedTextField
import com.example.component.theme.CustomSmallShapes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.component.text.OverlineText
import com.example.component.theme.CustomMediumShapes
import com.example.component.theme.Gray

@Composable
fun AuthTextField(
    value: MutableState<String>,
    label: Int,
    isOverLineText: Boolean = false,
    forgotPassword: Int? = null,
    isEnabled: Boolean = true,
) {
    Column {
        Text(
            text = stringResource(id = label),
            modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp),
            textAlign = TextAlign.Start,
            color = Gray.p300
        )
        TextField(
            enabled = isEnabled,
            modifier = Modifier.fillMaxWidth(),
            value = value.value,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Gray.p900,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                value.value = it
            },
            shape = CustomSmallShapes.medium,
            singleLine = true,
        )
        if (isOverLineText) {
            OverlineText(text = forgotPassword!!, modifier = Modifier.padding(top = 5.dp).align(Alignment.End))
        }

    }
}