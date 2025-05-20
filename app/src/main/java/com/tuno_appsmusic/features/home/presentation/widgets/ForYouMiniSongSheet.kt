package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuno_appsmusic.R

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
            .wrapContentHeight()
    ) {
        // Drag handle
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(Color(0xFFFFFFFF).copy(alpha = 0.7f))
            )
        }

        // Cover dan title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = coverRes),
                contentDescription = "Cover",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFEEEEEE))
            )
            Spacer(modifier = Modifier.width(14.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 0.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = songTitle,
                    color = Color.White,
                    fontSize = 20.sp,
                    maxLines = 2,
                    lineHeight = 24.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = artist,
                    color = Color(0xFFB0B0B0),
                    fontSize = 16.sp,
                    maxLines = 1
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color(0xFF323232)
        )

        // ==== Action List Pakai Asset Sendiri ====
        Spacer(modifier = Modifier.height(12.dp))
        ActionRow(
            iconRes = R.drawable.ic_download,
            text = "Download Lagu"
        )
        Spacer(modifier = Modifier.height(16.dp))
        ActionRow(
            iconRes = R.drawable.ic_add_playlist,
            text = "Tambahkan kedalam Playlist"
        )
        Spacer(modifier = Modifier.height(16.dp))
        ActionRow(
            iconRes = R.drawable.ic_dislike,
            text = "Tidak Tertarik"
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun ActionRow(iconRes: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(18.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 17.sp,
            maxLines = 1
        )
    }
}
