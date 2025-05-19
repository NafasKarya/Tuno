package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.tuno_appsmusic.R
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForYouBigCardWithMiniSheet(
    isLoading: Boolean = false,
    title: String = "Hindia - Rumah ke Rumah",
    artistName: String = "Hindia",
    artistDesc: String = "Dengerin Hindia untuk biar aktivitas jadi makin seru dan keren chau lihat lebih banyak caption ini harusnya akan tampil penuh kalau tombol lebih banyak diklik! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin suscipit, libero a molestie consectetur, sapien erat facilisis felis, non dictum orci erat eget lorem.",
    artistAvatar: Int = R.drawable.profile
) {
    var expanded by remember { mutableStateOf(false) }
    var showMiniSheet by remember { mutableStateOf(false) }
    var isPressed by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    // Scale animation state
    val scale by animateFloatAsState(if (isPressed) 0.96f else 1f, label = "cardScale")

    Column {
        // CARD UTAMA
        ForYouBigCardContent(
            isLoading = isLoading,
            title = title,
            artistName = artistName,
            artistDesc = artistDesc,
            artistAvatar = artistAvatar,
            expanded = expanded,
            onExpandToggle = { expanded = !expanded },
            onMoreClick = {
                showMiniSheet = true
                coroutineScope.launch { sheetState.show() }
            },
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = {
                            showMiniSheet = true
                            coroutineScope.launch { sheetState.show() }
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
        )

        // MINI PLAYER BOTTOM SHEET
        if (showMiniSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    coroutineScope.launch { sheetState.hide() }
                    showMiniSheet = false
                },
                sheetState = sheetState,
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                containerColor = Color(0xFF181818)
            ) {
                ForYouMiniSongSheet(
                    coverRes = artistAvatar,
                    songTitle = title,
                    artist = artistName
                )
            }
        }
    }
}
