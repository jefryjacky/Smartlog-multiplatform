package com.jefryjacky.smartlog.domain.entity

import kotlinx.datetime.LocalDateTime

data class LogEntity(
    val date: LocalDateTime,
    val tag: String,
    val message: String,
    val error: String? = null
)