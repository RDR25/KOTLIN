package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val Input = findViewById<EditText>(R.id.editTextTextPersonName2)
        val Btn= findViewById<Button>(R.id.button2)
        val Result = findViewById<TextView>(R.id.textView2)

        Btn.setOnClickListener(View.OnClickListener {
            val num:Int =  Input.text.toString().toInt()
            var i:Int = 1
            var s:String =""
            while(true)
            {
                if(num<i)
                {
                    break
                }
                s+= "$i@"
                ++i
            }
            Result.setText(s)
        })
    }
}