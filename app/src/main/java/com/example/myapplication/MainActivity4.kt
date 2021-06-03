package com.example.myapplication

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val input1 = findViewById<EditText>(R.id.editTextTextPersonName)
        val input2 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val operator = findViewById<Spinner>(R.id.spinner2)
        val btn = findViewById<Button>(R.id.button3)
        val result = findViewById<TextView>(R.id.tv)

        btn.setOnClickListener(View.OnClickListener {

            val num1 = input1.text.toString().toDouble()
            val num2 = input2.text.toString().toDouble()

            val op = operator.selectedItem.toString()
            when(op)
            {
                "+" -> result.setText("Addition of $num1 and $num2 is "+ add(num1,num2))
                "-" -> result.setText("Subtraction of $num1 and $num2 is "+ sub(num1,num2))
                "*" -> result.setText("Multiplication of $num1 and $num2 is "+ mul(num1,num2))
                "/" -> result.setText("Division of $num1 and $num2 is "+ div(num1,num2))
            }

        })
    }
    fun add(num1:Double,num2:Double):Double =num1+num2
    fun sub(num1: Double,num2: Double):Double = num1-num2
    fun mul(num1: Double,num2: Double):Double = num1*num2
    fun div(num1: Double,num2: Double):Double = num1/num2
}