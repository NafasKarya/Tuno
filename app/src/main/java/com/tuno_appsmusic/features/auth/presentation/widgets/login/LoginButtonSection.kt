package com.tuno_appsmusic.features.auth.presentation.widgets

import ScreenUtils
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun LoginButtonSection(fontSize: TextUnit) {
    Button(
        onClick = {
            // Handle login
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCCFF00),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth()
            .height(ScreenUtils.scaleDp(50.dp))
    ) {
        Text("Continue", fontSize = fontSize, fontWeight = FontWeight.Bold)
    }
}
