package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.Text // ← pakai Material 2!

@Composable
fun ForYouMiniSongSheet(
    coverRes: Int,
    songTitle: String,
    artist: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF181818),
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
            )
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        // Drag indicator
        Box(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
                .width(56.dp)
                .height(5.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.7f))
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = coverRes),
                contentDescription = "Cover",
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFDDDDDD))
            )
            Spacer(Modifier.width(18.dp))
            Column {
                Text(
                    text = songTitle,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = artist,
                    color = Color(0xFFB0B0B0),
                    fontSize = 16.sp
                )
            }
        }
        Spacer(Modifier.height(18.dp))
        // Tambah isi lain di sini kalau perlu
    }
}
