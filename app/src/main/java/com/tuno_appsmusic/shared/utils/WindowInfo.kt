package com.tuno_appsmusic.shared.utils

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.windowsizeclass.*

data class WindowInfo(
    val widthSizeClass: WindowWidthSizeClass,
    val heightSizeClass: WindowHeightSizeClass
)

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun rememberWindowInfo(): WindowInfo {
    val activity = LocalContext.current as Activity
    val windowSizeClass = calculateWindowSizeClass(activity)

    return WindowInfo(
        widthSizeClass = windowSizeClass.widthSizeClass,
        heightSizeClass = windowSizeClass.heightSizeClass
    )
}
