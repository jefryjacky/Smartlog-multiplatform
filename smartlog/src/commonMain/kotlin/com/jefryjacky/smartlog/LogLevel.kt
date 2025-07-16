package com.jefryjacky.smartlog

enum class LogLevel(val priority: Int, val levelName: String) {
    VERBOSE(2, "VERBOSE"),
    DEBUG(3, "DEBUG"),
    INFO(4, "INFO"),
    WARN(5, "WARN"),
    ERROR(6, "ERROR"),
    ASSERT(7, "ASSERT");

    companion object{
        fun fromPriority(priority: Int): LogLevel? {
            for (level in entries) {
                if (level.priority == priority) {
                    return level
                }
            }
            return null
        }
    }
}