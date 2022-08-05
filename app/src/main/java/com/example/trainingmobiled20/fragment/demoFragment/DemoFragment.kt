package com.example.trainingmobiled20.fragment.demoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingmobiled20.data.Student
import com.example.trainingmobiled20.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {

    private lateinit var binding: FragmentDemoBinding
    private val studentList = mutableListOf(Student())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDemoBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        loadData()
        val demoRecyclerViewAdapter = DemoRecyclerViewAdapter(studentList)
        binding.recyclerViewDemo.adapter = demoRecyclerViewAdapter
    }

    private fun loadData() {
        repeat(5) {
            studentList.add(Student())
        }
    }
}