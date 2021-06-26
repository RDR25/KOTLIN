package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class timeTable1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table1)

        val cse = findViewById<TextView>(R.id.s_cse)
        val it = findViewById<TextView>(R.id.s_it)
        val ece = findViewById<TextView>(R.id.s_ece)
        val eie = findViewById<TextView>(R.id.s_eie)

        var branchList = arrayListOf<TextView>();

        branchList.add(cse)
        branchList.add(ece)
        branchList.add(eie)
        branchList.add(it)

        for(branch in branchList)
        {
            branch.setOnClickListener(View.OnClickListener {
                val Next:Intent = Intent(this,s_activity3()::class.java)
                Next.putExtra("name",branch.text)
                startActivity(Next)
            })
        }



    }
}