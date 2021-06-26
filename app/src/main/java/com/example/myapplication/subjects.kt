package com.example.myapplication

class subjects {
    fun branchSChedule():ArrayList<subjectsAllocation>{
        var Branch = arrayListOf<subjectsAllocation>()
        var CSE =subjectsAllocation("Java","DBMS","DM","OS","BEFA")
        var ECE = subjectsAllocation("Java","DBMS","DM","OS","BEFA")
        var EIE = subjectsAllocation("ASD","ADAW","ADA","D","W")
        var IT = subjectsAllocation("DBMS","DM","Java","BEFA","OS")
        Branch.add(CSE)
        Branch.add(ECE)
        Branch.add(EIE)
        Branch.add(IT)
        return Branch
    }



}