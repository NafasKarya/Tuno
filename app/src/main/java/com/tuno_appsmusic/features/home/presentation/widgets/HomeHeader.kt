package com.tuno_appsmusic.features.home.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.statusBarsPadding
import com.tuno_appsmusic.shared.font.Inter28ptBlack


@Composable
fun HomeHeader(
    profileImageRes: Int
) {
    val greeting = "Hello, ${getGreeting()}"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = greeting,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = androidx.compose.ui.graphics.Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp,
                    fontFamily = Inter28ptBlack
                ),
                modifier = Modifier.padding(start = 4.dp)
            )
            Image(
                painter = painterResource(profileImageRes),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
        }
    }
}

