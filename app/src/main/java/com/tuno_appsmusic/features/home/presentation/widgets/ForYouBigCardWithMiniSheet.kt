package com.tuno_appsmusic.features.home.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ForYouBigCardWithMiniSheet() {
    // State scaffold & sheet
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            // ISI BOTTOM SHEET - nempel, bisa drag
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF181818),
                        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                    )
                    .padding(32.dp)
            ) {
                Text("Hello, This is Bottom Sheet", color = Color.White)
            }
        },
        sheetPeekHeight = 0.dp // Sheet disembunyikan waktu awal
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Button(
                onClick = {
                    coroutineScope.launch { sheetState.bottomSheetState.expand() }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("BUKA BOTTOM SHEET")
            }
        }
    }
}
