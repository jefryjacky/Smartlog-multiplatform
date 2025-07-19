package com.jefryjacky.smartlog.ui

import androidx.compose.runtime.Composable
import com.jefryjacky.smartlog.LogLevel
import org.jetbrains.compose.resources.stringResource
import smartlogginapp.smartlog.generated.resources.Res
import smartlogginapp.smartlog.generated.resources.assert
import smartlogginapp.smartlog.generated.resources.debug
import smartlogginapp.smartlog.generated.resources.error
import smartlogginapp.smartlog.generated.resources.info
import smartlogginapp.smartlog.generated.resources.verbose
import smartlogginapp.smartlog.generated.resources.warning

val logLevelMap = linkedMapOf(
    Pair(LogLevel.VERBOSE,Res.string.verbose),
    Pair(LogLevel.DEBUG, Res.string.debug),
    Pair(LogLevel.INFO, Res.string.info),
    Pair(LogLevel.WARN, Res.string.warning),
    Pair(LogLevel.ERROR, Res.string.error),
    Pair(LogLevel.ASSERT, Res.string.assert),
)

@Composable
fun LogLevel.stringResource(): String{
    return stringResource(logLevelMap[this]!!)
}