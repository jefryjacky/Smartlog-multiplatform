package com.jefryjacky.smartloggingapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform