package com.jefryjacky.smartlog.ui.logs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.domain.entity.LogEntity
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@Composable
fun LogContent(state: LogState) {
    LazyColumn {
        items(state.logs.size) { index ->
            val log = state.logs[index]
            Row {
                Text(text = log.date.toString())
                Text(text = log.message)
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Preview()
@Composable
fun LogContentPreview(){
    val state = LogState(listOf(LogEntity(
        date = Clock.System.now().toLocalDateTime(TimeZone.UTC),
        "tag", logLevel = LogLevel.VERBOSE,"message")))
    LogContent(state)
}