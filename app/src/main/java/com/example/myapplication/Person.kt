package com.example.myapplication

class Person {
    var name:String? = null
        get()=field
        set(value) {
            field = value?.uppercase()
        }
    var gender:String? = null
    var age:Int = 0
    get()=field
    set(value) = if(value<18) field=0 else field=value



}
