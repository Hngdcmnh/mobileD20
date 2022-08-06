package com.example.trainingmobiled20

class Student(
    val name:String = "Student Name" + idNum++,
    val birthYear: Int = if(idNum % 2 == 0) 2002 else 2003,

) {
    companion object{
        private var idNum = 1
    }

}