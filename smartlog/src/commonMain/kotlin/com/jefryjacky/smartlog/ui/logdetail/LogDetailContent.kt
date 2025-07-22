package com.jefryjacky.smartlog.ui.logdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.domain.entity.LogEntity
import com.jefryjacky.smartlog.ui.theme.onBackgroundDark
import com.jefryjacky.smartlog.ui.theme.redDarkMode
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import smartlogginapp.smartlog.generated.resources.Res
import smartlogginapp.smartlog.generated.resources.error
import smartlogginapp.smartlog.generated.resources.message
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import androidx.compose.runtime.getValue


@Composable
fun LogDetailContent(state: LogDetailState) {

    val color = if ((state.log?.logLevel?.priority
            ?: LogLevel.VERBOSE.priority) >= LogLevel.ERROR.priority
    ) {
        redDarkMode
    } else {
        MaterialTheme.colorScheme.onBackground
    }


    Scaffold {

        Column(
            modifier = Modifier.padding(it)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "${stringResource(Res.string.message)}:",
                color = color)
            Text(text = state.log?.message ?: "",
                color = color)
            Spacer(modifier = Modifier.height(16.dp))
            state.log?.error?.let {
                Text(text = "${stringResource(Res.string.error)}:",
                    color = color)
                Text(
                    text = it,
                    color = color
                )
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Preview
@Composable
fun LogDetailContentPreview() {
    val log = LogEntity(
        1,
        date = Clock.System.now().toLocalDateTime(TimeZone.UTC),
        "tag", logLevel = LogLevel.VERBOSE, "message"
    )
    LogDetailContent(LogDetailState(log))
}