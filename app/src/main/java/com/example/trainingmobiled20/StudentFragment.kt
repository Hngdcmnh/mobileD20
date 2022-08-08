package com.example.trainingmobiled20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trainingmobiled20.databinding.FragmentStudentBinding

class StudentFragment : Fragment() {

    private lateinit var binding: FragmentStudentBinding
    private val adapter = StudentAdapter(this::onTitleClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentBinding.inflate(inflater,container,false)
        setupData()
        return binding.root
    }

    private fun setupData() {
        val students = ArrayList<Student>()
        for(i in 1..15){
            students.add(Student("Học sinh thứ $i",2000+i))
        }
        binding.rvStudent.adapter = adapter
        adapter.setData(students)
    }
    private fun onTitleClick(student: Student,position:Int){
        Toast.makeText(context, student.name, Toast.LENGTH_SHORT).show()
        adapter.notifyItemChanged(position)
    }

}


