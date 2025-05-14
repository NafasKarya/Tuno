package com.tuno_appsmusic.features.onboarding.pages

import ScreenUtils
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuno_appsmusic.shared.utils.rememberWindowInfo
import com.tuno_appsmusic.features.onboarding.presentation.widgets.*

@Composable
fun OnboardingPage(navController: NavController) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val windowInfo = rememberWindowInfo()

    val titleFontSize = ScreenUtils.scaleFontSize(
        when (windowInfo.widthSizeClass) {
            androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Compact -> 18f
            androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Medium -> 22f
            androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Expanded -> 26f
            else -> 18f
        }
    )
    val bodyFontSize = ScreenUtils.scaleFontSize(titleFontSize.value * 0.85f)

    Box(modifier = Modifier.fillMaxSize()) {
        // ✅ WebView video background, anti flicker
        OnboardingBackground()

        // ✅ Konten UI tetap modular & terpisah
        OnboardingContentLayer(navController, titleFontSize, bodyFontSize)
    }
}
