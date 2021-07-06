package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.launch

class RoomDBActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_dbactvity)

        var rcv = findViewById<RecyclerView>(R.id.r_recycleView)
        rcv.layoutManager=LinearLayoutManager(this)

        var adp = MyAdapter()

        var db = Room.databaseBuilder(this,UserDB::class.java,"kmit.db").build()


        lifecycleScope.launch {

            var dao = db.userDao()

            //var user = user(0,"Ram","Reddy",35)
            //dao.addUser(user)

            var userList = dao.readAllData()

            adp.setData(userList)
        }

        rcv.adapter = adp
    }
}