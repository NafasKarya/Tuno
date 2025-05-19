package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.tuno_appsmusic.R
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

data class MoodPlaylistDummy(
    val subtitle: String,
    val imageRes: Int
)

// List dummy card hanya subtitle & image
val dummyPlaylistList = listOf(
    MoodPlaylistDummy("Awali pagi dengan semangat baru!", R.drawable.profile),
    MoodPlaylistDummy("Tetap fokus, tetap produktif.", R.drawable.profile),
    MoodPlaylistDummy("Rabu santai bareng musik!", R.drawable.profile),
    MoodPlaylistDummy("Kamis penuh inspirasi!", R.drawable.profile),
    MoodPlaylistDummy("Jumat berkah, semangat kerja.", R.drawable.profile),
    MoodPlaylistDummy("Akhir pekan chill vibes.", R.drawable.profile),
    MoodPlaylistDummy("Santai bareng keluarga.", R.drawable.profile)
)

@Composable
fun MoodSeninPlaylistSection(
    isLoading: Boolean = false
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Mood Monday",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 27.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)
                .placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer(),
                    color = Color(0xFF383838)
                )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            val showDummy = if (isLoading) List(7) { null } else dummyPlaylistList
            showDummy.forEachIndexed { idx, dummy ->
                MoodSeninPlaylistCard(
                    subtitle = dummy?.subtitle.orEmpty(),
                    imageRes = dummy?.imageRes ?: R.drawable.profile,
                    isLoading = isLoading
                )
                if (idx < 6) Spacer(modifier = Modifier.width(18.dp))
            }
        }
    }
}

@Composable
fun MoodSeninPlaylistCard(
    subtitle: String = "",
    imageRes: Int = R.drawable.profile,
    isLoading: Boolean = false
) {
    Column(
        modifier = Modifier
            .width(180.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(14.dp))
                .placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer(),
                    color = Color(0xFF383838)
                )
        ) {
            if (!isLoading) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = subtitle,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        // Subtitle doang (tanpa title)
        Text(
            text = if (isLoading) "" else subtitle,
            color = Color(0xFFD9D9D9),
            fontSize = 15.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer(),
                    color = Color(0xFF383838)
                )
        )
    }
}
