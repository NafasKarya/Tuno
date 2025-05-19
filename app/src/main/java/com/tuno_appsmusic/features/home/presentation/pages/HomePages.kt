package com.tuno_appsmusic.features.home.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuno_appsmusic.R
import com.tuno_appsmusic.features.home.presentation.widgets.*
import kotlinx.coroutines.delay

@Composable
fun HomePages(navController: NavController) {
    // Daftar genre
    val genres = listOf("All", "Pop", "Rock", "Indie", "R&B", "Jazz", "Dangdut", "Electronic")

    // State untuk genre yang dipilih
    var selectedGenre by remember { mutableStateOf("All") }

    // Data album cards (pakai asset drawable)
    val albumCards = listOf(
        AlbumCard(R.drawable.profile, "Hindia - Evaluasi"),
        AlbumCard(R.drawable.profile, "Nadin Amizah"),
        AlbumCard(R.drawable.profile, "Feby Putri"),
        AlbumCard(R.drawable.profile, "Payung Teduh")
    )

    var isLoading by remember { mutableStateOf(true) }

    // Jalankan shimmer selama 1 detik saat pertama kali load
    LaunchedEffect(Unit) {
        delay(1000)
        isLoading = false
    }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 24.dp)
        ) {
            // Header profil
            HomeHeader(
                profileImageRes = R.drawable.profile
            )
            Spacer(modifier = Modifier.height(12.dp))
            GenreFilterBar(
                genres = genres,
                selectedGenre = selectedGenre,
                onGenreSelected = { selectedGenre = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            AlbumCardGrid(albumCards = albumCards)
            Spacer(modifier = Modifier.height(36.dp))

            // Playlist Mood Senin
            MoodSeninPlaylistSection(isLoading = isLoading)
            Spacer(modifier = Modifier.height(32.dp))

            // Title & Big Card dipisah jadi widget!
            ForYouTitle()
            ForYouBigCard(isLoading = isLoading)
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}
