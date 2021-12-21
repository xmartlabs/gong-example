package com.xmartlabs.redditposts.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.xmartlabs.redditposts.R
import com.xmartlabs.redditposts.ui.screens.mainscreen.MainScreen
import com.xmartlabs.redditposts.ui.theme.AppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.time.Duration

class MainActivity : ComponentActivity() {
    companion object {
        private val SPLASH_ANIMATION_TIME = Duration.milliseconds(300)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        val splashWasDisplayed = savedInstanceState != null
        if (!splashWasDisplayed) {
            installSplashScreen()
                .setOnExitAnimationListener(this::handleActivityState)
        } else {
            setTheme(R.style.AppTheme)
            handleActivityState(null)
        }
    }

    private fun handleActivityState(splashScreenViewProvider: SplashScreenViewProvider?) {
        lifecycleScope.launch {
            if (splashScreenViewProvider == null) {
                activityContentView()
            } else {
                // Get icon instance and start a fade out animation
                splashScreenViewProvider.iconView
                    .animate()
                    .setDuration(SPLASH_ANIMATION_TIME.inWholeMilliseconds)
                    .alpha(0f)
                    .withEndAction {
                        splashScreenViewProvider.remove()
                        activityContentView()
                    }.start()
            }
        }
    }

    private fun activityContentView() {
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                AppTheme {
                    AppNavigationManager()
                }
            }
        }
    }
}

@Composable
fun AppNavigationManager() {
    val navigationController: NavHostController = rememberNavController()
    val startDestination = Screens.MAIN_SCREEN
    NavHost(navController = navigationController, startDestination = startDestination) {
        composable(Screens.MAIN_SCREEN) {
            MainScreen()
        }
    }
}
