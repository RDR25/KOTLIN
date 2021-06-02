package com.example.myapplication

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
            var con:Double = 0.0
            when(op)
            {
                "+" -> {
                    con= (num1+num2).toDouble()
                    result.setText("Addition of $num1 and $num2 is $con")
                }
                "-" -> {
                    con= (num1-num2).toDouble()
                    result.setText("Subtraction of $num1 and $num2 is $con")
                }
                "*" -> {
                    con= (num1*num2).toDouble()
                    result.setText("Multiplictaion of $num1 and $num2 is $con")
                }
                "/" -> {
                    con=  num1/num2.toDouble()
                    result.setText("Division of $num1 and $num2 is $con")
                }
            }
        })
    }
}