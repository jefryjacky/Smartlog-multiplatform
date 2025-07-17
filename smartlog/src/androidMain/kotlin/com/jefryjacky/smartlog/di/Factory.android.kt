package com.jefryjacky.smartlog.di

import android.app.Application
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.jefryjacky.smartlog.database.AppRoomDatabase
import kotlinx.coroutines.Dispatchers

actual class Factory(
    private val app: Application
) {
    actual fun createRoomDatabase(): AppRoomDatabase {
        val dbFile = app.getDatabasePath("log.db")
        return Room
            .databaseBuilder<AppRoomDatabase>(
                context = app,
                name = dbFile.absolutePath,
            ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}