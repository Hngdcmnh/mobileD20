package com.example.trainingmobiled20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentFragment:Fragment() {

    private lateinit var  adapter: StudentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var students : ArrayList<Student>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //dataInput()
        return inflater.inflate(R.layout.student_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInput()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = StudentAdapter(students)
        recyclerView.adapter = adapter
    }

    private fun dataInput(){
        students = arrayListOf<Student>()
        for(i in 1..10){
            students.add(Student())
        }
    }

}