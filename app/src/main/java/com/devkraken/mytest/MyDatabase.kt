package com.devkraken.mytest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}

