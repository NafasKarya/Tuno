package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tuno_appsmusic.R
import kotlinx.coroutines.launch

// INI PENTING: Import yang benar!
import com.tuno_appsmusic.features.home.presentation.widgets.ForYouMiniSongSheet

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ForYouBigCardWithMiniSheet(
    content: @Composable (
        onShowSheet: () -> Unit,
        isSheetVisible: Boolean
    ) -> Unit
) {
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }

    // Buka/tutup sheet saat showSheet berubah
    LaunchedEffect(showSheet) {
        coroutineScope.launch {
            if (showSheet) {
                sheetState.bottomSheetState.expand()
            } else {
                sheetState.bottomSheetState.collapse()
            }
        }
    }

    // Reset showSheet jika sheet ditutup (drag)
    LaunchedEffect(sheetState.bottomSheetState.isCollapsed) {
        if (sheetState.bottomSheetState.isCollapsed) {
            showSheet = false
        }
    }

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF181818),
                        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                    )
                    .padding(24.dp)
            ) {
                ForYouMiniSongSheet(
                    coverRes = R.drawable.profile,
                    songTitle = "Hindia - Rumah ke Rumah",
                    artist = "Hindia",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        sheetBackgroundColor = Color(0xFF181818),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            content(
                onShowSheet = { showSheet = true },
                isSheetVisible = !sheetState.bottomSheetState.isCollapsed
            )

            val overlayAlpha = if (!sheetState.bottomSheetState.isCollapsed) 0.7f else 0f
            if (overlayAlpha > 0f) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = overlayAlpha))
                        .clickable(enabled = true, onClick = {}) // Disable click outside
                )
            }
        }
    }
}
