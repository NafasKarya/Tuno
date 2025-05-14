package com.tuno_appsmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tuno_appsmusic.features.splash.pages.SplashPage
import com.tuno_appsmusic.features.onboarding.pages.OnboardingPage
import com.tuno_appsmusic.features.auth.presentation.pages.LoginPage // ✅ Tambahkan ini

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Surface(color = MaterialTheme.colorScheme.background) {
                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable("splash") {
                        SplashPage(navController)
                    }
                    composable("onboarding") {
                        OnboardingPage(navController)
                    }
                    composable("login") { // ✅ Tambahkan route ini
                        LoginPage(navController)
                    }
                }
            }
        }
    }
}
