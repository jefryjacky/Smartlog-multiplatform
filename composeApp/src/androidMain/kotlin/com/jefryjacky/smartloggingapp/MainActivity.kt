package com.jefryjacky.smartloggingapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jefryjacky.smartlog.LogActivity
import com.jefryjacky.smartlog.LogCatPrinter
import com.jefryjacky.smartlog.SmartLog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            App{
                val intent = Intent(this, LogActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App{}
}