package com.jefryjacky.smartlog.ui.logs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import smartlogginapp.smartlog.generated.resources.Res
import smartlogginapp.smartlog.generated.resources.assert
import smartlogginapp.smartlog.generated.resources.baseline_play_arrow_24
import smartlogginapp.smartlog.generated.resources.debug
import smartlogginapp.smartlog.generated.resources.error
import smartlogginapp.smartlog.generated.resources.info
import smartlogginapp.smartlog.generated.resources.outline_info_24
import smartlogginapp.smartlog.generated.resources.outline_warning_24
import smartlogginapp.smartlog.generated.resources.outline_error_24
import smartlogginapp.smartlog.generated.resources.outline_filter_alt_24
import smartlogginapp.smartlog.generated.resources.verbose
import smartlogginapp.smartlog.generated.resources.warning
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(FormatStringsInDatetimeFormats::class)
@Composable
fun LogContent(state: LogState) {
    val colorMap = mapOf(
        Pair(LogLevel.VERBOSE, Color(0xFF69F0AE)),
        Pair(LogLevel.DEBUG, Color(0xFF69F0AE)),
        Pair(LogLevel.INFO, Color(0xFF69F0AE)),
        Pair(LogLevel.WARN, Color(0xFFFFAB40)),
        Pair(LogLevel.ERROR, Color(0xFFFF5252)),
        Pair(LogLevel.ASSERT, Color(0xFFFF5252)),
    )

    val iconMap = mapOf(
        Pair(LogLevel.VERBOSE,Res.drawable.outline_info_24),
        Pair(LogLevel.DEBUG, Res.drawable.outline_info_24),
        Pair(LogLevel.INFO, Res.drawable.outline_info_24),
        Pair(LogLevel.WARN, Res.drawable.outline_warning_24),
        Pair(LogLevel.ERROR, Res.drawable.outline_error_24),
        Pair(LogLevel.ASSERT, Res.drawable.outline_error_24),
    )

    val textMap = mapOf(
        Pair(LogLevel.VERBOSE,Res.string.verbose),
        Pair(LogLevel.DEBUG, Res.string.debug),
        Pair(LogLevel.INFO, Res.string.info),
        Pair(LogLevel.WARN, Res.string.warning),
        Pair(LogLevel.ERROR, Res.string.error),
        Pair(LogLevel.ASSERT, Res.string.assert),
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(50.dp),
                actions = {
                IconButton(onClick = {}){
                    Icon(painter = painterResource(Res.drawable.baseline_play_arrow_24),
                        null)
                }
                IconButton(onClick = {}){
                    Icon(painter = painterResource(Res.drawable.outline_filter_alt_24),
                        null)
                }
            })
        }
    ) {
        LazyColumn(
            Modifier.padding(it).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(state.logs,
                key = {it.id}) { log->
                Card(
                    colors = CardDefaults.cardColors().copy(containerColor = colorMap[log.logLevel]!!),
                    border = BorderStroke(3.dp, colorMap[log.logLevel]!!),
                    shape = RoundedCornerShape(6.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(iconMap[log.logLevel]!!),
                                null)
                            Spacer(Modifier.width(4.dp))
                            Text(stringResource(textMap[log.logLevel]!!),
                                style = MaterialTheme.typography.bodySmall)
                        }

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
        1,
        date = Clock.System.now().toLocalDateTime(TimeZone.UTC),
        "tag", logLevel = LogLevel.VERBOSE,"message")))
    LogContent(state)
}