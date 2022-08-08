package com.example.trainingmobiled20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentFragment : Fragment() {
    private lateinit var adapter: StudentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var students: ArrayList<Student>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pushData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = StudentAdapter(students)
        recyclerView.adapter = adapter
    }

    private fun pushData(){
        students = arrayListOf<Student>()
        students.add(Student("Cao duy a","2002"))
        students.add(Student("Cao duy b","2002"))
        students.add(Student("Cao duy c","2002"))
        students.add(Student("Cao duy d","2002"))
        students.add(Student("Cao duy e","2002"))
    }
}