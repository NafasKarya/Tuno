package com.tuno_appsmusic.features.home.presentation.widgets

import ForYouOverlayShadow
import ForYouVideoBackground
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.layout.onGloballyPositioned
import kotlinx.coroutines.launch
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.boundsInWindow

@Composable
fun ForYouBigCardContent(
    isLoading: Boolean,
    title: String,
    artistName: String,
    artistDesc: String,
    artistAvatar: Int,
    expanded: Boolean,
    onMoreClick: () -> Unit,
    onExpandToggle: () -> Unit,
    onImageLongPress: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isPressed by remember { mutableStateOf(false) }
    val scaleAnim by animateFloatAsState(
        targetValue = if (isPressed) 0.96f else 1f,
        label = "longPressCardScale"
    )

    // ===== DETEKSI VISIBILITY CARD FULL DI LAYAR =====
    val view = LocalView.current
    var cardFullyVisible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    Box(
        modifier = modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth()
            .then(
                if (expanded) Modifier.wrapContentHeight()
                else Modifier.aspectRatio(1.2f)
            )
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFF181818))
            .scale(scaleAnim)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        isPressed = true
                        onImageLongPress()
                        kotlinx.coroutines.GlobalScope.launch {
                            kotlinx.coroutines.delay(120)
                            isPressed = false
                        }
                    },
                    onPress = {
                        isPressed = true
                        try {
                            awaitRelease()
                        } finally {
                            isPressed = false
                        }
                    }
                )
            }
            // INI LOGICNYA: cek apakah seluruh card masuk ke viewport
            .onGloballyPositioned { layoutCoordinates ->
                val rect: Rect = layoutCoordinates.boundsInWindow()
                val screenHeightPx = view.height.toFloat()
                val marginDp = 32.dp // atau sesuaikan 24/48 dsb, semakin besar semakin strict
                val marginPx = with(density) { marginDp.toPx() }
                val cardTop = rect.top
                val cardBottom = rect.bottom
                val isFully = cardTop >= marginPx && cardBottom <= (screenHeightPx - marginPx)
                cardFullyVisible = isFully
                println("cardTop=$cardTop cardBottom=$cardBottom screenHeight=$screenHeightPx margin=$marginPx FULL=$isFully")
            }


    ) {
        ForYouVideoBackground(
            isLoading = isLoading,
            play = cardFullyVisible, // <--- GANTI playWhenVisible MENJADI play
            modifier = Modifier.matchParentSize()
        )
        ForYouOverlayShadow(
            modifier = Modifier.matchParentSize()
        )
        if (!isLoading) {
            ForYouCardContent(
                title = title,
                artistName = artistName,
                artistDesc = artistDesc,
                artistAvatar = artistAvatar,
                expanded = expanded,
                onMoreClick = onMoreClick,
                onExpandToggle = onExpandToggle
            )
        }
    }
}
