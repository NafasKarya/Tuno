package com.tuno_appsmusic.features.onboarding.pages

import ScreenUtils
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.tuno_appsmusic.R
import com.tuno_appsmusic.shared.utils.rememberWindowInfo
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import kotlinx.coroutines.delay

@Composable
fun ScreenUtils.scaleDp(base: Dp): Dp {
    val width = screenWidth()
    val factor = when {
        width <= 320 -> 0.85f
        width <= 400 -> 1.0f
        width <= 600 -> 1.1f
        else -> 1.25f
    }
    return base * factor
}

@Composable
fun OnboardingPage(navController: NavController) {
    val windowInfo = rememberWindowInfo()

    // Font size responsif
    val titleFontSize = ScreenUtils.scaleFontSize(
        when (windowInfo.widthSizeClass) {
            WindowWidthSizeClass.Compact -> 18f
            WindowWidthSizeClass.Medium -> 22f
            WindowWidthSizeClass.Expanded -> 26f
            else -> 18f
        }
    )

    val bodyFontSize = ScreenUtils.scaleFontSize(titleFontSize.value * 0.85f)

    // Animasi fade-in konten
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(500)
        visible = true
    }

    val textAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "textAlpha"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.tuno_splash),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize()
        )

        // Gradasi overlay bawah → atas
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF222831),
                            Color.Black.copy(alpha = 0.7f),
                            Color.Transparent.copy(alpha = 0.05f)
                        ),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(0f, 0f)
                    )
                )
        )

        // Konten utama
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = ScreenUtils.scaleDp(24.dp),
                    vertical = ScreenUtils.scaleDp(36.dp)
                ),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Indicator dot
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(3) {
                    val isActive = it == 1
                    Box(
                        modifier = Modifier
                            .padding(horizontal = ScreenUtils.scaleDp(3.dp))
                            .height(ScreenUtils.scaleDp(6.dp))
                            .width(if (isActive) ScreenUtils.scaleDp(18.dp) else ScreenUtils.scaleDp(6.dp))
                            .background(
                                color = if (isActive) Color.White else Color.LightGray,
                                shape = RoundedCornerShape(50)
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(20.dp)))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.alpha(textAlpha)
            ) {
                Text(
                    text = "Stream & Connect - Your All in One Social Experience",
                    fontSize = titleFontSize,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = titleFontSize * 1.35f
                )

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(10.dp)))

                Text(
                    text = "Discover live streaming and community-driven interaction — all in one place. Join, engage, and stay connected like never before.",
                    color = Color(0xFFCCCCCC),
                    fontSize = bodyFontSize,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(horizontal = ScreenUtils.scaleDp(12.dp))
                )
            }

            Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(28.dp)))

            // Sign In Button
            OutlinedButton(
                onClick = { /* TODO */ },
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

            // Get Started Button
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
    }
}
