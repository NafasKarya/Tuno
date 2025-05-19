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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// Data model untuk AlbumCard
data class AlbumCard(
    val imageRes: Int,
    val title: String
)

// Satu card album, proporsional sesuai contoh gambar kamu
@Composable
fun AlbumCardItem(
    imageRes: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFF444140))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = title,
                modifier = Modifier
                    .size(56.dp) // Full tinggi card
                    .clip(RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier.weight(1f),
                maxLines = 1
            )
        }
    }
}

// Grid card album (2 kolom per baris)
@Composable
fun AlbumCardGrid(albumCards: List<AlbumCard>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
    albumCards.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { card ->
                    AlbumCardItem(
                        imageRes = card.imageRes,
                        title = card.title,
                        modifier = Modifier.weight(1f)
                    )
                }
                // Tambahkan spacer jika di row cuma ada 1 card
                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
