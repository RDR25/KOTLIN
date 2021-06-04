package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val nameVal = findViewById<EditText>(R.id.et_6)
        val genderVal = findViewById<EditText>(R.id.gender_6)
        val ageVal =findViewById<EditText>(R.id.age_6)
        val submit = findViewById<Button>(R.id.submit_6)

        submit.setOnClickListener(View.OnClickListener {
            var person = Person()
            person.name = nameVal.text.toString()
            person.gender = genderVal.text.toString()
            person.age = ageVal.text.toString().toInt()

            val result = if(person.age != 0) "${person.name}" else "Person is Minor"

            Toast.makeText(this,result,Toast.LENGTH_LONG).show()

        })
    }
}