import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object ScreenUtils {

    @Composable
    fun screenWidth() = LocalConfiguration.current.screenWidthDp

    @Composable
    fun screenHeight() = LocalConfiguration.current.screenHeightDp

    @Composable
    fun isTablet() = LocalConfiguration.current.smallestScreenWidthDp >= 600

    @Composable
    fun isPortrait() =
        LocalConfiguration.current.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    @Composable
    fun scaleFontSize(baseSp: Float): TextUnit {
        val width = screenWidth()
        val factor = when {
            width <= 320 -> 0.85f
            width <= 400 -> 1.0f
            width <= 600 -> 1.1f
            else -> 1.25f
        }
        return (baseSp * factor).sp
    }

    // ⬇ Tambahkan ini langsung ke dalam object ScreenUtils
    @Composable
    fun scaleDp(base: Dp): Dp {
        val width = screenWidth()
        val factor = when {
            width <= 320 -> 0.85f
            width <= 400 -> 1.0f
            width <= 600 -> 1.1f
            else -> 1.25f
        }
        return base * factor
    }
}
