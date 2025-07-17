package com.jefryjacky.smartlog.ui.logs

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LogContent(state: LogState) {
    LazyColumn {
        items(state.logs.size) { index ->
            val log = state.logs[index]
            Text(text = log.toString())
        }
    }
}

@Preview()
@Composable
fun LogContentPreview(){
    val state = LogState()
    LogContent(state)
}