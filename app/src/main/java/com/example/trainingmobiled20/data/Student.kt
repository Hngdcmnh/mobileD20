package com.example.trainingmobiled20.data

data class Student(
    val name: String = "Student Name" + idNum++,
    val yearOfBirth: Int = if (idNum % 2 == 0) 1995 else 1996,
    var expandable: Boolean = false
) {
    companion object {
        private var idNum = 1
    }
}
