package com.tuno_appsmusic.features.onboarding.presentation.widgets

import ScreenUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingIndicator(
    total: Int = 3,
    activeIndex: Int = 1 // indeks yang aktif, default di tengah (0,1,2)
) {
    val activeColor = Color(0xFF6DFF8A)
    val inactiveColor = Color.White
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(total) { index ->
            val isActive = index == activeIndex
            Box(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .height(4.dp)
                    .width(if (isActive) 44.dp else 32.dp)
                    .background(
                        color = if (isActive) activeColor else inactiveColor,
                        shape = RoundedCornerShape(50)
                    )
            )
        }
    }
}
