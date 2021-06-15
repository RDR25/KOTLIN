package com.example.myapplication


class Admin
{
    var name:String=""
    set(value)
    {
        field=value.reversed()
    }
    var gender:String="Male"
    fun display() {
        println("$name is $gender")
    }
}