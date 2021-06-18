package com.example.myapplication

 open class boy(var name:String,var age:Int) {
     var a:Int=10
     var b:Int=124
     var c:Int=12
     var d:Int=16

     open fun display()
    {
        println("$name is $age years old")
    }
}

class boy1(name: String,age: Int):boy(name, age){
    override fun display(){
        super.display()
        age=15
        println("$name is $age years old")
    }
}
/*
class boy1(name:String,age:Int):boy(name,age){
    override fun display()
    {
        super.display()
        age=15
        println("$name is $age years old")
    }
}*/