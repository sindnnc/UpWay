package com.example.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.example.component.text.ButtonText
import com.example.component.theme.CustomSmallShapes

@Composable
fun AuthButton(
    color: Color = MaterialTheme.colors.primary,
    height: Dp,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth().height(height * 0.065F),
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CustomSmallShapes.medium,
        onClick = onClick,
    ) {
        content()
    }
}

