package com.example.trainingmobiled20

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trainingmobiled20.adapters.DemoRecyclerAdapter
import com.example.trainingmobiled20.databinding.FragmentDemoRecyclerBinding
import com.example.trainingmobiled20.model.Student

class DemoRecyclerFragment : Fragment(R.layout.fragment_demo_recycler) {
    private lateinit var binding: FragmentDemoRecyclerBinding
    val TAG = "TAG"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDemoRecyclerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val studentList = getStudentList()
        setUpRecyclerView(studentList)
    }

    private fun getStudentList(): List<Student> {
        return listOf(
            Student("Student 1", "1/1/2002"),
            Student("Student 2", "2/1/2002"),
            Student("Student 3", "3/1/2002")
        )
    }

    private fun setUpRecyclerView(studentList: List<Student>) {
        binding.rvDemoRecycler.adapter = DemoRecyclerAdapter(studentList) {
            onItemClick(it)
        }
    }

    private fun onItemClick(it: Student) {
        Toast.makeText(this.context, "Name: ${it.name}, DOB: ${it.dob}", Toast.LENGTH_SHORT)
            .show()
    }
}