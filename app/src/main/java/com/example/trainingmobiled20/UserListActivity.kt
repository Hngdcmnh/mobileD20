package com.example.trainingmobiled20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingmobiled20.databinding.ActivityUsersBinding

class UserListActivity : AppCompatActivity() {
    lateinit var students: ArrayList<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUsersBinding.inflate(layoutInflater)
        val rvStudents = binding.rvStudents
        students = Student.createStudentsList(20)
        val adapter = StudentsAdapter(students)
        rvStudents.adapter = adapter
        rvStudents.layoutManager = LinearLayoutManager(this)
        setContentView(binding.root)
    }
}