package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SonetQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonet_quiz)

        val name = findViewById<EditText>(R.id.q_name)
        val btn = findViewById<Button>(R.id.q_start)

        btn.setOnClickListener(View.OnClickListener {
           // Log.i("Name","$name")
           var q_name= name.text.toString()
            if(q_name.isEmpty())
            {
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }
            else
            {
                val next:Intent= Intent(this,quizActivity()::class.java)
                next.putExtra("name",q_name)
                startActivity(next)
                finish()
            }
        })
    }
}