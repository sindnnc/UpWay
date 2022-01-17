package com.example.component.textfield

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.component.theme.CustomSmallShapes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    value: MutableState<String>,
    isIcon: Boolean = false,
    icon: Int? = null,
    isEnabled: Boolean = true,
    label: Int
) {
    OutlinedTextField(
        value = value.value,
        onValueChange = { value.value = it },
        shape = CustomSmallShapes.medium,
        modifier = modifier.fillMaxWidth(),
        trailingIcon = {
            if (isIcon) Icon(
                painter = painterResource(id = icon!!),
                contentDescription = "trailing icon"
            )
        },
        enabled = isEnabled,
        label = { Text(text = stringResource(id = label)) }
    )
}