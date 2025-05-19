package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.tuno_appsmusic.R

@Composable
fun ForYouBigCard(
    isLoading: Boolean = false,
    title: String = "Hindia - Rumah ke Rumah"
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth()
            .aspectRatio(1.2f)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFF181818)),
        contentAlignment = Alignment.BottomStart
    ) {
        // Background Image + shimmer
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

        // Overlay: title + play button (hanya muncul jika !isLoading)
        if (!isLoading) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xAA181818)) // semi-transparent bg for text readability
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_play), // Pakai icon play PNG/SVG yang sudah kamu upload, misal file-Y8VALcwrn5pGxM5f94NNKB.png
                    contentDescription = "Play",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }
}
