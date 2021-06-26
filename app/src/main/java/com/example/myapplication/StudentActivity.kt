package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        var onlineClass = findViewById<TextView>(R.id.s_timeTable)

        onlineClass.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,timeTable1()::class.java)
            startActivity(intent)
        })
    }
}