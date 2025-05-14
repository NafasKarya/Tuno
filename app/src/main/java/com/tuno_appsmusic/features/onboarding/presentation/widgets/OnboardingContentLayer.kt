package com.tuno_appsmusic.features.onboarding.presentation.widgets

import ScreenUtils
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun OnboardingContentLayer(
    navController: NavController,
    titleFontSize: TextUnit,
    bodyFontSize: TextUnit
) {
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
        OnboardingIndicator()
        Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(20.dp)))
        OnboardingContent(titleFontSize, bodyFontSize, textAlpha)
        Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(28.dp)))
        OnboardingButtons(navController)
    }
}
