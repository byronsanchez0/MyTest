package com.devkraken.mytest

import android.content.Context
import androidx.room.Room

object MyDatabaseProvider {
    private var database: MyDatabase? = null
    fun getDatabase(context: Context): MyDatabase {
        if (database == null) {
            database = Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java, "inventory-db"
            ).build()
        }
        return database!!
    }
}