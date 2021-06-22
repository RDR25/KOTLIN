package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class QuizActivityRes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_res)

        var name = findViewById<TextView>(R.id.q_details)
        name.text =intent.getStringExtra("Name")
        var detail = name.text.toString()
        Log.i("-------->","$detail")

        name.setText("Hey $detail you have sucessfully completed the quiz !")
        var Marks = findViewById<TextView>(R.id.q_res)
        Marks.text =intent.getStringExtra("marks")
        var res = Marks.text.toString()
        Log.i("-------->","$Marks")
        Marks.setText("Hey you got $res")

        var Home = findViewById<Button>(R.id.q_home)

        Home.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,SonetQuiz()::class.java)
            startActivity(intent)
            finish()
        })
    }
}