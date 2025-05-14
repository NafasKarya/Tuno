package com.tuno_appsmusic.features.splash.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tuno_appsmusic.shared.utils.rememberWindowInfo
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

@Composable
fun SplashPage() {
    val windowInfo = rememberWindowInfo()

    val fontSize = when (windowInfo.widthSizeClass) {
        WindowWidthSizeClass.Compact -> ScreenUtils.scaleFontSize(20f)
        WindowWidthSizeClass.Medium -> ScreenUtils.scaleFontSize(24f)
        WindowWidthSizeClass.Expanded -> ScreenUtils.scaleFontSize(28f)
        else -> ScreenUtils.scaleFontSize(20f)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF222831)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            val isTablet = windowInfo.widthSizeClass >= WindowWidthSizeClass.Medium

            if (isTablet) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(32.dp))
                    Text(
                        text = "Tuno is starting...",
                        fontSize = fontSize,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                }
            } else {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Tuno is starting...",
                        fontSize = fontSize,
                        color = Color.White
                    )
                }
            }
        }
    }
}
