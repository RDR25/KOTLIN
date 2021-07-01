package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class RoomDBActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_dbactvity)

        var db = Room.databaseBuilder(this,UserDB::class.java,"kmit.db").build()


        lifecycleScope.launch {
            var dao = db.userDao()

            var User = user(0,"scott","reddy",24)
            dao.addUser(User)

        }
    }
}