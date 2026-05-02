package com.jefryjacky.smartlog

import androidx.compose.ui.window.ComposeUIViewController
import com.jefryjacky.smartlog.ui.LogApp
import com.jefryjacky.smartlog.ui.theme.LogTheme
import platform.UIKit.UIViewController

fun LogViewController(): UIViewController = ComposeUIViewController {
    LogTheme {
        LogApp {
            // Navigation back or other actions could be handled here if needed
        }
    }
}
