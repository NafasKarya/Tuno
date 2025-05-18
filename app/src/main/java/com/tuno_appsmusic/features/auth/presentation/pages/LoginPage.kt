package com.tuno_appsmusic.features.auth.presentation.pages

import ScreenUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuno_appsmusic.shared.utils.rememberWindowInfo
import com.tuno_appsmusic.features.auth.presentation.widgets.*

@Composable
fun LoginPage(navController: NavController) {
    val windowInfo = rememberWindowInfo()
    val titleFontSize = ScreenUtils.scaleFontSize(
        when (windowInfo.widthSizeClass) {
            WindowWidthSizeClass.Compact -> 20f
            WindowWidthSizeClass.Medium -> 24f
            WindowWidthSizeClass.Expanded -> 30f
            else -> 20f
        }
    )
    val bodyFontSize = ScreenUtils.scaleFontSize(titleFontSize.value * 0.75f)
    val smallFontSize = ScreenUtils.scaleFontSize(titleFontSize.value * 0.55f)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val isWide = windowInfo.widthSizeClass == WindowWidthSizeClass.Expanded
    val layoutModifier = if (isWide) Modifier.fillMaxWidth(0.6f) else Modifier.fillMaxWidth()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222831))
            .padding(ScreenUtils.scaleDp(24.dp))
    ) {
        val content = @Composable {
            LoginContent(
                email = email,
                password = password,
                passwordVisible = passwordVisible,
                onEmailChange = { email = it },
                onPasswordChange = { password = it },
                onTogglePasswordVisibility = { passwordVisible = !passwordVisible },
                navController = navController,
                titleFontSize = titleFontSize,
                bodyFontSize = bodyFontSize,
                smallFontSize = smallFontSize,
                layoutModifier = layoutModifier
            )
        }
        if (isWide) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) { content() }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) { content() }
        }
    }
}
