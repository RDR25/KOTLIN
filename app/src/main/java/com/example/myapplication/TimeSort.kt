package com.example.myapplication

class TimeSort{


    fun time():ArrayList<timings> {
        var Branch = arrayListOf<timings>()
        var periodTimmings = timings("9:00 AM to 9:50 AM","10:00 AM to 10:50 AM","11:00 AM to 11:50 AM","1:00 PM to 1:50 PM","2:00 PM to 2:50 PM")
        Branch.add(periodTimmings)
        return Branch
    }

}