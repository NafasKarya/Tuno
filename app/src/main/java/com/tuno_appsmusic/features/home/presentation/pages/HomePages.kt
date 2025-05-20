package com.tuno_appsmusic.features.home.presentation.pages

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuno_appsmusic.R
import com.tuno_appsmusic.features.home.presentation.widgets.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomePages(navController: NavController) {
    val genres = listOf("All", "Pop", "Rock", "Indie", "R&B", "Jazz", "Dangdut", "Electronic")
    var selectedGenre by remember { mutableStateOf("All") }
    val albumCards = listOf(
        AlbumCard(R.drawable.profile, "Hindia - Evaluasi"),
        AlbumCard(R.drawable.profile, "Nadin Amizah"),
        AlbumCard(R.drawable.profile, "Feby Putri"),
        AlbumCard(R.drawable.profile, "Payung Teduh")
    )
    var isLoading by remember { mutableStateOf(true) }

    // BOTTOM SHEET SCAFFOLD (Material 2)
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )
    val coroutineScope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }

    // --- Tambahkan state untuk ekspansi card ---
    var cardExpanded by remember { mutableStateOf(false) }
    // State untuk bottom nav
    var selectedNavIndex by remember { mutableStateOf(0) }

    // Simulasi loading
    LaunchedEffect(Unit) {
        delay(1000)
        isLoading = false
    }

    // Buka/tutup sheet dari trigger long press
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
            Box(
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0B0A0A),
                            Color(0xFF211F1F)
                        )
                    )
                )
        ) {
            // KONTEN UTAMA
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState(),
                        enabled = sheetState.bottomSheetState.isCollapsed // Nonaktifkan scroll jika sheet buka
                    )
                    .padding(bottom = 32.dp) // ruang buat navbar
            ) {
                HomeHeader(profileImageRes = R.drawable.profile)
                Spacer(modifier = Modifier.height(12.dp))
                GenreFilterBar(
                    genres = genres,
                    selectedGenre = selectedGenre,
                    onGenreSelected = { selectedGenre = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                AlbumCardGrid(albumCards = albumCards)
                Spacer(modifier = Modifier.height(36.dp))
                MoodSeninPlaylistSection(isLoading = isLoading, navController = navController)
                Spacer(modifier = Modifier.height(32.dp))
                ForYouTitle()
                // ========== UBAH DI SINI ==========
                ForYouBigCardContent(
                    isLoading = isLoading,
                    title = "Hindia - Rumah ke Rumah",
                    artistName = "Hindia",
                    artistDesc = "Evaluasi, Cincin, Evakuasi, Kita Kesana, Secukupnya, Membasuh, Dehidrasi, Untuk Apa / Untuk Apa?, Rumah ke Rumah, Perkara Tubuh, Belum Tidur, Jam Makan Siang, Membasuh, etc",
                    artistAvatar = R.drawable.profile,
                    expanded = cardExpanded,
                    onExpandToggle = { cardExpanded = !cardExpanded }, // <--- state toggle!
                    onMoreClick = { },
                    onImageLongPress = { showSheet = true },
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(28.dp))
            }

            // ANIMATED OVERLAY (fade in/out, bisa di-drag untuk dismiss sheet)
            val targetAlpha = if (!sheetState.bottomSheetState.isCollapsed) 0.7f else 0f
            val animatedAlpha by animateFloatAsState(
                targetValue = targetAlpha,
                label = "overlayAlphaAnim"
            )
            if (animatedAlpha > 0f) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = animatedAlpha))
                )
            }

            // **BottomNavBar sebagai overlay bawah**
            BottomNavBar(
                selectedIndex = selectedNavIndex,
                onItemSelected = { selectedNavIndex = it },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                // .padding(bottom = 20.dp) // <-- HAPUS INI!
            )
        }
    }
}
