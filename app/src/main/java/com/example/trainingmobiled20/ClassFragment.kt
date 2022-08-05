package com.example.trainingmobiled20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ClassFragment : Fragment() {

    private lateinit var adapter : Adapter;
    private  lateinit var recyclerView: RecyclerView
    private lateinit var students: ArrayList<Student>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataInit()
        return inflater.inflate(R.layout.fragment_class, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)
        adapter= Adapter(students)
        recyclerView.adapter=adapter
    }
    private fun dataInit() {
        students= arrayListOf<Student>()
        for(i in 1..10)
        {
            val name= "Student Name$i"
            val age=(1995..2002).random()
            students.add(Student(name,age))
        }

    }


}