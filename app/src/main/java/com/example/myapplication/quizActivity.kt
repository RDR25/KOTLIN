package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class quizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var q_list = listOf<String>("RDR","Asd","da")

    }
}