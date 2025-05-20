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
import com.tuno_appsmusic.features.auth.presentation.pages.LoginPage
import com.tuno_appsmusic.features.home.presentation.pages.HomePages
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.runtime.CompositionLocalProvider
import com.tuno_appsmusic.features.playingPage.presentation.pages.PlayingPages

class MainActivity : ComponentActivity() {
    @OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Matikan jelly/overscroll untuk seluruh app Compose!
            CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
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
                        composable("login") {
                            LoginPage(navController)
                        }
                        composable("homePages") {
                            HomePages(navController)
                        }
                        // --- Route playing TANPA parameter ---
                        composable("playing") {
                            PlayingPages(navController)
                        }
                    }
                }
            }
        }
    }
}
