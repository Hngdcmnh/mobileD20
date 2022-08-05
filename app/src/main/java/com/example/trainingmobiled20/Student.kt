package com.example.trainingmobiled20

class Student(val name: String) {

    companion object {
        private var lastStudentId = 0
        fun createStudentsList(numStudents: Int): ArrayList<Student> {
            var year: String? = null
            val students = ArrayList<Student>()
            for (i in 1..numStudents) {
                ++lastStudentId
                year = if (lastStudentId % 2 != 0)
                    "1995"
                else
                    "1996"
                students.add(
                    Student("Student Name " + lastStudentId + "\n" + year)
                )
            }
            return students
        }
    }
}