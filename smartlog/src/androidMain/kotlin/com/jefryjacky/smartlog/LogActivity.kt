package com.jefryjacky.smartlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jefryjacky.smartlog.ui.LogApp
import com.jefryjacky.smartlog.ui.theme.LogTheme

class LogActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogTheme {
                LogApp {

                }
            }
        }
    }
}