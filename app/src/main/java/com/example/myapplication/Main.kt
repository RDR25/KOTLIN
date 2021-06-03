package com.example.myapplication

import android.animation.BidirectionalTypeConverter
import java.util.*

fun main()
{
    feedFood()
}

fun feedFood()
{
    val day:String = WhichDay()
    val Food:String = foodToFeed(day)
    println("Today is $day you need to feed $Food")
    var Change:Boolean = change()

    if(Change || day=="Sunday")
    {
        println("you need to change water")
    }
    else
    {
        println("No need to change water")
    }
}


fun change():Boolean
{
    var Temp:Boolean = checkTemp()
    var Dirt:Boolean = checkDirt()
    if((Temp || Dirt))
    {
        return true
    }
    else
    {
        return false
    }
}

fun WhichDay():String
{
    val Day:String
    val arr = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    Day = arr[Random().nextInt(arr.size)]
    return Day
}


fun foodToFeed(day:String):String
{
    var food:String=""
    when(day)
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

fun checkDirt():Boolean
{
    val Dirt:Int = 29
    if(Dirt>=30){
        return true
    }
    else{
        return false
    }
}

fun checkTemp():Boolean
{
    val Temp:Int = 20
    if(Temp>=30){
        return true
    }
    else{
        return false
    }
}