package com.jefryjacky.smartlog.di

import com.jefryjacky.smartlog.database.AppRoomDatabase

expect class Factory {
    fun createRoomDatabase(): AppRoomDatabase
}