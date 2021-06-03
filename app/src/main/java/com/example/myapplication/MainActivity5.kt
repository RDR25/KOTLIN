package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val Temp = findViewById<EditText>(R.id.temp)
        val Dirt = findViewById<EditText>(R.id.dirt)
        val btn = findViewById<Button>(R.id.btn1)
        val result = findViewById<TextView>(R.id.food)

        btn.setOnClickListener(View.OnClickListener {
            val tempVal= Temp.text.toString().toInt()
            val dirtVal = Dirt.text.toString().toInt()

            val Day = WhichDay()
            val Food =foodToFeed(Day)
            val ChangeWater = changeWater(Day,tempVal,dirtVal)
            result.setText("Today is $Day,So you need to feed Bob with $Food \n ${if (ChangeWater) "Change water" else "No need to change water"}")

        })
    }

    fun WhichDay():String
    {
        var Days = arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        var day:String = Days[Random().nextInt(Days.size)]
        return day
    }

    fun foodToFeed(Day:String):String
    {
        var food:String=""
        when(Day)
        {
            "Monday" ->food ="Flakes"
            "Tuesday" ->food ="Pellets"
            "Wednesday" ->food="Redworms"
            "Thursday" -> food="Granules"
            "Friday" -> food="Mosquitoes"
            "Saturday" -> food="Lettuce"
            "Sunday" -> food ="Planton"
        }
        return food
    }

    fun changeWater(Day: String,tempVal: Int,dirtVal: Int) : Boolean
    {
         return when
         {
             checkTemp(tempVal) -> true
             checkdirt(dirtVal) -> true
             checkSunday(Day) -> true

             else -> false
         }
    }

    fun checkTemp(tempVal:Int):Boolean = tempVal>=30
    fun checkdirt(dirtVal:Int):Boolean = dirtVal>=30
    fun checkSunday(Day:String):Boolean = Day == "Sunday"
}
