package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.tuno_appsmusic.R
import kotlinx.coroutines.launch
import androidx.compose.foundation.clickable


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
    onImageLongPress: () -> Unit, // <-- Trigger sheet
    modifier: Modifier = Modifier
) {
    // State animasi scale
    var isPressed by remember { mutableStateOf(false) }
    val scaleAnim by animateFloatAsState(
        targetValue = if (isPressed) 0.96f else 1f,
        label = "longPressCardScale"
    )

    Box(
        modifier = modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth()
            .let { if (expanded) it else it.aspectRatio(1.2f) }
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFF181818))
            .scale(scaleAnim) // <-- Card scale effect
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        isPressed = true
                        onImageLongPress()
                        // balikin animasi abis sheet muncul (delay opsional)
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
    ) {
        // --- ISI CARD SAMA PERSIS ---
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Mood Senin Big",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer(),
                    color = Color(0xFF383838)
                )
        )
        // Overlay shadow
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(
                            Color(0xA0000000),
                            Color(0x80000000),
                            Color(0xCC000000)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        if (!isLoading) {
            // Title & play button di pojok kiri-atas dan kanan-atas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, start = 18.dp, end = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Play",
                    modifier = Modifier.size(32.dp)
                )
            }
            // Icon kanan-tengah
            Column(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "Favorite",
                    modifier = Modifier.size(34.dp)
                )
                Spacer(modifier = Modifier.height(28.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_volume),
                    contentDescription = "Volume",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(28.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_more),
                    contentDescription = "More",
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { onMoreClick() } // Boleh kosong aja!
                )
            }
            // Section artis di kiri bawah
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 18.dp, bottom = 24.dp, end = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = artistAvatar),
                    contentDescription = "Artist Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = artistName,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    if (!expanded) {
                        val previewText = artistDesc.take(70)
                        Text(
                            text = buildAnnotatedString {
                                append(previewText)
                                append(" ")
                                withStyle(SpanStyle(color = Color(0xFF5EEA6F), fontWeight = FontWeight.Medium)) {
                                    append("lebih banyak")
                                }
                            },
                            color = Color.White,
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.clickable { onExpandToggle() }
                        )
                    } else {
                        Text(
                            text = buildAnnotatedString {
                                append(artistDesc)
                                append(" ")
                                withStyle(SpanStyle(color = Color(0xFF5EEA6F), fontWeight = FontWeight.Medium)) {
                                    append("lebih sedikit")
                                }
                            },
                            color = Color.White,
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            modifier = Modifier.clickable { onExpandToggle() }
                        )
                    }
                }
            }
        }
    }
}
