package com.example.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(user::class),version = 1,exportSchema = false)

abstract class UserDB: RoomDatabase() {
    abstract fun userDao():UserDao
}

