package com.tuno_appsmusic.features.onboarding.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.media3.common.util.UnstableApi
import com.tuno_appsmusic.R

@Composable
fun OnboardingBackground() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Ganti dengan gambar onboarding kamu
        Image(
            painter = painterResource(id = R.drawable.bg_1),
            contentDescription = "Onboarding Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Overlay gradasi di atas gambar
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF222831),
                            Color.Black.copy(alpha = 0.7f),
                            Color.Transparent.copy(alpha = 0.05f)
                        )
                    )
                )
        )
    }
}
