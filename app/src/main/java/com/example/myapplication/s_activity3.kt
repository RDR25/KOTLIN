package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class s_activity3 : AppCompatActivity() {
    var timetable = subjects()
    lateinit var today: String
    lateinit var Branch:String
    var TimeTabe =timetable.branchSChedule()
    var period= TimeSort()
    var specPeriod = period.time()
    lateinit var periodOne:TextView
    lateinit  var periodTwo:TextView
    lateinit var periodThree :TextView
    lateinit var periodFour :TextView
    lateinit var periodFive :TextView
    lateinit var home:Button
    lateinit var day:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sactivity3)

       periodOne = findViewById<TextView>(R.id.s_periodOne)
       periodTwo = findViewById<TextView>(R.id.s_periodTwo)
       periodThree = findViewById<TextView>(R.id.s_periodThree)
       periodFour = findViewById<TextView>(R.id.s_periodFour)
       periodFive = findViewById<TextView>(R.id.s_periodFive)
       home = findViewById(R.id.s_home)
       day = findViewById(R.id.s_day)
        today = checkDay()
       day.text  =today
        isSunday()

        home.setOnClickListener(View.OnClickListener {
            var moveActivity = Intent(this,StudentActivity()::class.java)
            startActivity(moveActivity)
        })

        var periodList = arrayListOf<TextView>(periodOne,periodTwo,periodThree,periodFour,periodFour,periodFive)

        for (period in periodList)
        {
            period.setOnClickListener(View.OnClickListener {
                var join = Intent(this,classJoinActivity()::class.java)
                join.putExtra("subject",period.text)
                join.putExtra("branch",Branch)
                startActivity(join)
            })
        }

    }

    private fun isSunday()
    {
        if( today == "Sunday")
        {
            periodOne.setText("Enjoy the weekend :)")
            periodTwo.setText("Enjoy the weekend :)")
            periodThree.setText("Enjoy the weekend :)")
            periodFour.setText("Enjoy the weekend :)")
            periodFive.setText("Enjoy the weekend :)")
        }
        else
        {
            setTimeTable()
        }
    }

    private fun checkDay():String
    {
        var day = arrayListOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
        var today = day.random()
        return today
    }

   private fun setTimeTable()
    {
        periodOne = findViewById(R.id.s_periodOne)
        Branch = intent.getStringExtra("name")!!

        when(Branch)
        {
            "CSE" -> {
                setPeriod1(0)
                setPeriod2(0)
                setPeriod3(0)
                setPeriod4(0)
                setPeriod5(0)
            }

            "ECE" -> {
                setPeriod1(1)
                setPeriod2(1)
                setPeriod3(1)
                setPeriod4(1)
                setPeriod5(1)
            }

            "EIE" -> {
                setPeriod1(2)
                setPeriod2(2)
                setPeriod3(2)
                setPeriod4(2)
                setPeriod5(2)
            }

            "IT" -> {
                setPeriod1(3)
                setPeriod2(3)
                setPeriod3(3)
                setPeriod4(3)
                setPeriod5(3)
            }
        }
    }

    private fun setPeriod1(id :Int)
    {
        var subject = TimeTabe[id].periodOne
        var time =specPeriod[0].periodOneTime
        periodOne.setText("$time - $subject")
    }
    private fun setPeriod2(id :Int)
    {
        var subject = TimeTabe[id].periodTwo
        var time =specPeriod[0].periodTwoTime
        periodTwo.setText("$time - $subject")
    }
    private fun setPeriod3(id :Int)
    {
        var subject = TimeTabe[id].periodThree
        var time =specPeriod[0].periodThreeTime
        periodThree.setText("$time - $subject")
    }
    private fun setPeriod4(id :Int)
    {
        var subject = TimeTabe[id].periodFour
        var time =specPeriod[0].periodFourTime
        periodFour.setText("$time - $subject")
    }
    private fun setPeriod5(id :Int)
    {
        var subject = TimeTabe[id].periodFive
        var time =specPeriod[0].periodFiveTime
        periodFive.setText("$time - $subject")
    }

}