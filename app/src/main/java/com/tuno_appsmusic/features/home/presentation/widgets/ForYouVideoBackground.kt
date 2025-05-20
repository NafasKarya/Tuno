import VideoPlayer
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import androidx.compose.ui.graphics.Color
import com.tuno_appsmusic.R

@Composable
fun ForYouVideoBackground(
    isLoading: Boolean,
    play: Boolean, // <-- param play dikontrol parent
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val packageName = context.packageName
    val videoUri = "android.resource://$packageName/raw/small"
    var videoReady by remember { mutableStateOf(false) }

    // Reset videoReady setiap play berubah ke false, biar shimmer muncul lagi
    LaunchedEffect(play) {
        if (!play) videoReady = false
    }

    Box(modifier = modifier) {
        when {
            isLoading -> {
                // Hanya shimmer saat loading awal
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Video Thumbnail",
                    modifier = Modifier
                        .matchParentSize()
                        .placeholder(
                            visible = true,
                            highlight = PlaceholderHighlight.shimmer(),
                            color = Color(0xFF383838)
                        ),
                    contentScale = ContentScale.Crop
                )
            }
            !videoReady -> {
                // Sudah tidak loading, tapi video belum siap: tampilkan thumbnail TANPA shimmer
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Video Thumbnail",
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        // Render VideoPlayer hanya kalau play == true
        if (play) {
            VideoPlayer(
                context = context,
                videoUrl = videoUri,
                modifier = Modifier.matchParentSize(),
                autoPlay = true,
                loop = true,
                onReady = { videoReady = true }
            )
        }
    }

}
