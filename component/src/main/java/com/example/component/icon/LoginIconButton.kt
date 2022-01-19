package com.example.component.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.component.theme.CustomMediumShapes
import com.example.component.theme.Gray


@Composable
fun LoginIconButton(icon: ImageVector, color: Color = Gray.p900, onClick: () -> Unit) {
    Box(
        modifier = Modifier.clip(CustomMediumShapes.medium)
            .clickable { onClick() }.background(color).padding(20.dp)
    ) {
        Icon(icon, "Icon Button", tint = Color.White)
    }
}