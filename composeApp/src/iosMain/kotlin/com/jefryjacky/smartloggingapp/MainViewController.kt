package com.jefryjacky.smartloggingapp

import androidx.compose.ui.window.ComposeUIViewController
import com.jefryjacky.smartlog.SmartLog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun MainViewController(onNavigateToLog: () -> Unit) = ComposeUIViewController {
    App(clicked = {
        runningLog()
        onNavigateToLog()
    })
}

private var loggingJob: Job? = null

private fun runningLog() {
    loggingJob?.cancel()
    loggingJob = CoroutineScope(Dispatchers.IO).launch {
        var count = 0
        while (true) {
            SmartLog.v("LogViewModel", "test message$count")
            delay(5000)
            SmartLog.d("LogViewModel", "test message$count")
            delay(5000)
            SmartLog.i("LogViewModel", "test message$count")
            delay(5000)
            SmartLog.w("LogViewModel", "test message$count")
            delay(5000)
            SmartLog.e("LogViewModel", "test message$count")
            delay(5000)
            SmartLog.wtf(
                "${count}LogViewModel",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
            ++count
        }
    }
}
