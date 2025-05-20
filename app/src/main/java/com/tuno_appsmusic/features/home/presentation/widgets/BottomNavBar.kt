package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuno_appsmusic.R

data class BottomNavItem(
    val label: String,
    val icon: Painter
)

@Composable
fun BottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        BottomNavItem("Home", painterResource(R.drawable.ic_download)),
        BottomNavItem("Accounts", painterResource(R.drawable.ic_download)),
        BottomNavItem("Scan QR", painterResource(R.drawable.ic_download)),
        BottomNavItem("Cards", painterResource(R.drawable.ic_download)),
        BottomNavItem("Profile", painterResource(R.drawable.ic_download))
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(Color(0xFF1C1C26)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            items.forEachIndexed { index, item ->
                val isActive = selectedIndex == index
                val activeColor = Color.White
                val inactiveColor = Color(0xFFB0B4C1)

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onItemSelected(index) }
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    // Indicator bar di atas
                    Box(
                        Modifier
                            .height(3.dp)
                            .width(38.dp)
                            .background(
                                color = if (isActive) Color(0xFF4F8CFF) else Color.Transparent
                            )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        tint = if (isActive) activeColor else inactiveColor,
                        modifier = Modifier.size(26.dp) // "sedang"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.label,
                        fontSize = 14.sp, // "sedang"
                        color = if (isActive) activeColor else inactiveColor
                    )
                }
            }
        }
    }
}
