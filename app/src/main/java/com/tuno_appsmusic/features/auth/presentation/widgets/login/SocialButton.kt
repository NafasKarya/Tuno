package com.tuno_appsmusic.features.auth.presentation.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SocialButton(iconRes: Int) {
    OutlinedButton(
        onClick = { /* Handle social login */ },
        shape = RoundedCornerShape(20),
        border = BorderStroke(1.dp, Color.Gray),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .width(120.dp)   // ⬅️ Lebar seperti "capsule"
            .height(48.dp)   // ⬅️ Tinggi tetap ramping
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Social Icon",
            modifier = Modifier.size(24.dp) // ⬅️ Icon proporsional
        )
    }
}
