package com.jefryjacky.smartlog.ui.logs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.domain.entity.LogEntity
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(FormatStringsInDatetimeFormats::class)
@Composable
fun LogContent(state: LogState) {
    val colorMap = mapOf<LogLevel, Color>(
        Pair(LogLevel.VERBOSE, Color(0xFF69F0AE)),
        Pair(LogLevel.DEBUG, Color(0xFF69F0AE)),
        Pair(LogLevel.INFO, Color(0xFF69F0AE)),
        Pair(LogLevel.WARN, Color(0xFFFFAB40)),
        Pair(LogLevel.ERROR, Color(0xFFFF5252)),
        Pair(LogLevel.ASSERT, Color(0xFFFF5252)),
    )

    Scaffold {
        LazyColumn(
            Modifier.padding(it).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(state.logs.size) { index ->
                val log = state.logs[index]
                Card(
                    colors = CardDefaults.cardColors().copy(containerColor = colorMap[log.logLevel]!!),
                    border = BorderStroke(3.dp, colorMap[log.logLevel]!!),
                    shape = RoundedCornerShape(6.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(text = log.message,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis)
                        Row {
                            Spacer(Modifier.weight(1f))
                            Text(text = log.date.format(LocalDateTime.Format {
                                byUnicodePattern("dd/MM/yyyy HH:mm:ss:SSSSSS")
                            }))
                        }
                    }
                }

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