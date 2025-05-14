package com.tuno_appsmusic.features.auth.presentation.pages

import ScreenUtils
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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

@SuppressLint("UnusedBoxWithConstraintsScope")
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
            Column(
                modifier = layoutModifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Login", fontSize = titleFontSize, fontWeight = FontWeight.Bold, color = Color.White)

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(4.dp)))

                Row {
                    Text("Don't have an account? ", color = Color.Gray, fontSize = bodyFontSize)
                    Text(
                        "Sign up",
                        color = Color(0xFFCCFF00),
                        fontSize = bodyFontSize,
                        modifier = Modifier.clickable {
                            navController.navigate("register")
                        }
                    )
                }

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(24.dp)))

                LoginFormSection(
                    email = email,
                    password = password,
                    passwordVisible = passwordVisible,
                    onEmailChange = { email = it },
                    onPasswordChange = { password = it },
                    onTogglePasswordVisibility = { passwordVisible = !passwordVisible }
                )

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(24.dp)))

                LoginButtonSection(fontSize = bodyFontSize)

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(24.dp)))

                Divider(color = Color.Gray.copy(alpha = 0.3f))

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(12.dp)))

                Text("or sign up with", color = Color.Gray, fontSize = bodyFontSize)

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(12.dp)))

                SignWithSection()

                Spacer(modifier = Modifier.height(ScreenUtils.scaleDp(24.dp)))

                Text(
                    text = "By clicking continue you agree to recognotes",
                    fontSize = smallFontSize,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Terms of use", color = Color(0xFFCCFF00), fontSize = smallFontSize)
                    Text(" and ", color = Color.Gray, fontSize = smallFontSize)
                    Text("Privacy policy", color = Color(0xFFCCFF00), fontSize = smallFontSize)
                }
            }
        }

        if (isWide) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                content()
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
            }
        }
    }
}
