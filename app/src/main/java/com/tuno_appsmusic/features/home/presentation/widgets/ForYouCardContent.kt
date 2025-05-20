package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuno_appsmusic.R

@Composable
fun ForYouCardContent(
    title: String,
    artistName: String,
    artistDesc: String,
    artistAvatar: Int,
    expanded: Boolean,
    onMoreClick: () -> Unit,
    onExpandToggle: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Title & play button di pojok kiri-atas dan kanan-atas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, start = 18.dp, end = 18.dp)
                .align(Alignment.TopStart),
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

        // Column icon kanan bawah (like, volume, more)
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 14.dp, bottom = 38.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = "Favorite",
                modifier = Modifier.size(34.dp)
            )
            Spacer(modifier = Modifier.height(34.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_volume),
                contentDescription = "Volume",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.height(38.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "More",
                modifier = Modifier
                    .size(22.dp)
                    .clickable { onMoreClick() }
            )
        }

        // Section artis di kiri bawah
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 18.dp, bottom = 24.dp, end = 48.dp),
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
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = artistName,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                if (!expanded) {
                    Text(
                        text = buildAnnotatedString {
                            append("Evaluasi, Cincin, Evakuasi, Kita Kesana ")
                            withStyle(
                                SpanStyle(
                                    color = Color(0xFF5EEA6F),
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append("lebih banyak")
                            }
                        },
                        color = Color.White,
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Clip,
                        modifier = Modifier
                            .padding(top = 1.dp)
                            .fillMaxWidth()
                            .clickable { onExpandToggle() }
                    )
                } else {
                    Text(
                        text = buildAnnotatedString {
                            append(artistDesc)
                            append(" ")
                            withStyle(
                                SpanStyle(
                                    color = Color(0xFF5EEA6F),
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append("lebih sedikit")
                            }
                        },
                        color = Color.White,
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        maxLines = Int.MAX_VALUE,
                        overflow = TextOverflow.Clip,
                        modifier = Modifier
                            .padding(top = 1.dp)
                            .fillMaxWidth()
                            .clickable { onExpandToggle() }
                    )
                }
            }
        }
    }
}
