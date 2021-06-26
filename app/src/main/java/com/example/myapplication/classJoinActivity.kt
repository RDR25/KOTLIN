package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView

class classJoinActivity : AppCompatActivity() {

    lateinit var Url:TextView
    lateinit var className:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_join)
        className = findViewById(R.id.s_className)

        var Home = findViewById<Button>(R.id.s_returnHome)
        Home.setOnClickListener(View.OnClickListener {
            var returnHome = Intent(this,StudentActivity()::class.java)
            startActivity(returnHome)
        })

        var subject = intent.getStringExtra("subject").toString()
        var Branch: String = intent.getStringExtra("branch")!!
        className.setText("$subject for $Branch  ")

        Url = findViewById(R.id.s_url)
        Url.setMovementMethod(LinkMovementMethod.getInstance());
    }
}