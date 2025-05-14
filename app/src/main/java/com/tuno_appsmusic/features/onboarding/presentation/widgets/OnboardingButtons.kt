package com.tuno_appsmusic.features.onboarding.presentation.widgets

import ScreenUtils
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun OnboardingButtons(navController: NavController) {
    OutlinedButton(
        onClick = {
            navController.navigate("login") // Ganti dengan route ke halaman login-mu
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(ScreenUtils.scaleDp(48.dp)),
        shape = RoundedCornerShape(ScreenUtils.scaleDp(30.dp)),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.4f)),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        )
    ) {
        Text("Sign In", fontSize = ScreenUtils.scaleFontSize(14f))
    }

    Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(12.dp)))

    Button(
        onClick = {
            navController.navigate("home") {
                popUpTo("onboarding") { inclusive = true }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(ScreenUtils.scaleDp(48.dp)),
        shape = RoundedCornerShape(ScreenUtils.scaleDp(30.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text("Get Started", fontSize = ScreenUtils.scaleFontSize(14f))
    }
}
