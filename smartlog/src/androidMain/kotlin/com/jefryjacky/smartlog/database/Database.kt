package com.jefryjacky.smartlog.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<AppRoomDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("log.db")
    return Room.databaseBuilder<AppRoomDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}