package com.tuno_appsmusic.features.onboarding.presentation.widgets

import ScreenUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingIndicator() {
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
}
