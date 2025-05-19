package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuno_appsmusic.R
import androidx.compose.foundation.Image

@Composable
fun SongMiniBottomSheet(
    coverRes: Int = R.drawable.profile,
    songTitle: String = "Hindia - Rumah ke Rumah",
    artist: String = "Hindia",
    modifier: Modifier = Modifier
) {
    // Container utama
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF181818),
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
            )
            .padding(top = 20.dp, bottom = 8.dp)
    ) {
        // Swipe indicator
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(52.dp)
                .height(6.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.85f))
        )
        Spacer(modifier = Modifier.height(20.dp))
        // Cover, Title, Artist (row)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            // Album Art kotak rounded
            Image(
                painter = painterResource(id = coverRes),
                contentDescription = songTitle,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE3E3E3))
            )
            Spacer(modifier = Modifier.width(20.dp))
            // Song Info
            Column {
                Text(
                    text = songTitle,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = artist,
                    fontSize = 15.sp,
                    color = Color(0xFF8C8C8C),
                    fontWeight = FontWeight.Medium
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        // Batas bawah sheet (jika mau garis tipis)
        Box(
            Modifier
                .padding(top = 14.dp)
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xFF2A2A2A))
        )
    }
}
