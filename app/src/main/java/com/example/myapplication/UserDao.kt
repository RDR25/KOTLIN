package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(User:user)
    @Query("select * from user_table")
    suspend fun readAllData():List<user>

}