package com.jefryjacky.smartloggingapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.jefryjacky.smartlog.LogActivity
import com.jefryjacky.smartlog.LogCatPrinter
import com.jefryjacky.smartlog.SmartLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            App{
                runningLog()
                val intent = Intent(this, LogActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun runningLog(){
        lifecycleScope.launch(Dispatchers.IO) {
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
                    "${count }LogViewModel",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
                ++count
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App{}
}