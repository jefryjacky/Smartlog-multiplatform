package com.jefryjacky.smartlog.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LogContent() {
    Text(text = "Log Content")
}

@Preview()
@Composable
fun LogContentPreview(){
    LogContent()
}