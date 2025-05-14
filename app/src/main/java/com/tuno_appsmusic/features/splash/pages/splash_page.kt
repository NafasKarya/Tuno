package com.tuno_appsmusic.features.splash.pages

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tuno_appsmusic.R
import com.tuno_appsmusic.shared.utils.rememberWindowInfo
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import kotlinx.coroutines.delay

@Composable
fun SplashPage(navController: NavController) {
    val windowInfo = rememberWindowInfo()
    val isTablet = windowInfo.widthSizeClass >= WindowWidthSizeClass.Medium

    val fontSize = when (windowInfo.widthSizeClass) {
        WindowWidthSizeClass.Compact -> 20.sp
        WindowWidthSizeClass.Medium -> 24.sp
        WindowWidthSizeClass.Expanded -> 28.sp
        else -> 20.sp
    }

    val logoSize = if (isTablet) 320.dp else 240.dp
    var showSplash by remember { mutableStateOf(false) }

    // ⏳ Trigger animasi
    LaunchedEffect(Unit) {
        delay(300)
        showSplash = true
    }

    // ✅ Navigasi setelah total 2.2 detik (300ms + 1000ms + 800ms + cadangan)
    LaunchedEffect(Unit) {
        delay(2200)
        navController.navigate("onboarding") {
            popUpTo("splash") { inclusive = true }
        }
    }

    val logoAlpha by animateFloatAsState(
        targetValue = if (showSplash) 1f else 0f,
        animationSpec = tween(1000, easing = FastOutSlowInEasing),
        label = "logoAlpha"
    )

    val textOffsetY by animateDpAsState(
        targetValue = if (showSplash) 0.dp else (-40).dp,
        animationSpec = tween(800, delayMillis = 500),
        label = "textOffset"
    )

    val textAlpha by animateFloatAsState(
        targetValue = if (showSplash) 1f else 0f,
        animationSpec = tween(800, delayMillis = 500),
        label = "textAlpha"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF222831)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (showSplash) {
                if (isTablet) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tuno_splash),
                            contentDescription = "Tuno Logo",
                            modifier = Modifier
                                .size(logoSize)
                                .alpha(logoAlpha)
                        )
                        Spacer(modifier = Modifier.width(fontSize.value.dp))
                        Text(
                            text = "Just tunes. No limits",
                            fontSize = fontSize,
                            color = Color.White,
                            modifier = Modifier
                                .offset(y = textOffsetY)
                                .alpha(textAlpha)
                        )
                    }
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.tuno_splash),
                            contentDescription = "Tuno Logo",
                            modifier = Modifier
                                .size(logoSize)
                                .alpha(logoAlpha)
                        )
                        Spacer(modifier = Modifier.height(fontSize.value.dp / 2))
                        Text(
                            text = "Just tunes. No limits",
                            fontSize = fontSize,
                            color = Color.White,
                            modifier = Modifier
                                .offset(y = textOffsetY)
                                .alpha(textAlpha)
                        )
                    }
                }
            }
        }
    }
}
