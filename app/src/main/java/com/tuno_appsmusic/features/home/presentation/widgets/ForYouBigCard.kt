//package com.tuno_appsmusic.features.home.presentation.widgets
//
//import androidx.compose.runtime.*
//import androidx.compose.foundation.layout.Column
//
//@Composable
//fun ForYouBigCardWithMiniSheet(
//    isLoading: Boolean = false,
//    title: String = "Hindia - Rumah ke Rumah",
//    artistName: String = "Hindia",
//    artistDesc: String = "Dengerin Hindia untuk biar aktivitas jadi makin seru dan keren chau lihat lebih banyak caption ini harusnya akan tampil penuh kalau tombol lebih banyak diklik! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin suscipit, libero a molestie consectetur, sapien erat facilisis felis, non dictum orci erat eget lorem.",
//    artistAvatar: Int = com.tuno_appsmusic.R.drawable.profile
//) {
//    var expanded by remember { mutableStateOf(false) }
//    var showMiniSheet by remember { mutableStateOf(false) }
//
//    Column {
//        ForYouBigCardContent(
//            isLoading = isLoading,
//            title = title,
//            artistName = artistName,
//            artistDesc = artistDesc,
//            artistAvatar = artistAvatar,
//            expanded = expanded,
//            onExpandClick = { expanded = !expanded },
//            onShowMiniSheet = { showMiniSheet = true }
//        )
//        // MINI PLAYER BOTTOM SHEET
//        if (showMiniSheet) {
//            ForYouMiniSongSheet(
//                coverRes = artistAvatar,
//                songTitle = title,
//                artist = artistName,
//                onDismiss = { showMiniSheet = false }
//            )
//        }
//    }
//}
