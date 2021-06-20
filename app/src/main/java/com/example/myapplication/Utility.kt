package com.example.myapplication

class Utility {
    fun getQuestion():ArrayList<Questions>{
        var list = ArrayList<Questions>()
        var q1 = Questions(1,"Kotlin is developed by?","Google","JetBrains","Adobe","Microsoft",2)
        var q2 = Questions(2,"Which file extension is used to save Kotlin files.",".java",".kot",".kt",".android",3)
        var q3 = Questions(3,"All classes in Kotlin classes are by default?","public","final","sealed","abstract",1)
        list.add(q1)
        list.add(q2)
        list.add(q3)
        return list
    }


}
