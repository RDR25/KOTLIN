package com.example.myapplication

class Admin(var name:String,var gender:String)
{
    init {
        var age = 10
        println(age)
    }

    fun display() {
        println("$name is $gender")
    }
}