package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        var btn=findViewById<Button>(R.id.btn)
        var txt =findViewById<TextView>(R.id.txt)

        btn.setOnClickListener(View.OnClickListener{
            var radius:Double=editTextNumber.text.toString().toDouble()
            val pi:Double=3.141

            var area = pi * radius * radius
            txt.setText("Area of Circle is $area")
        })
    }
}