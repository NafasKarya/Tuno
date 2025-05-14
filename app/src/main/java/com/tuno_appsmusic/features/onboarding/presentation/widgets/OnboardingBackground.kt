package com.tuno_appsmusic.features.onboarding.presentation.widgets

import android.webkit.WebView
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.util.UnstableApi

@OptIn(UnstableApi::class)
@Composable
fun OnboardingBackground() {
    Box(modifier = Modifier.fillMaxSize()) {
        NativeVideoBackground()

        // Overlay gradasi di atas video
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

