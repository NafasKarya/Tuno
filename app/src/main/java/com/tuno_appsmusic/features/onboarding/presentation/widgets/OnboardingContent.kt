package com.tuno_appsmusic.features.onboarding.presentation.widgets

import ScreenUtils
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text

@Composable
fun OnboardingContent(
    titleFontSize: TextUnit,
    bodyFontSize: TextUnit,
    textAlpha: Float
) {
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
}
