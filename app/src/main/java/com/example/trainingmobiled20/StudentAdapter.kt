package com.example.trainingmobiled20

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val studentList:List<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return studentList.size
    }

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById(R.id.tvName) as TextView
        val tvBirthYear : TextView = view.findViewById(R.id.tvBirthyear) as TextView
        val btnDetail : AppCompatButton = view.findViewById(R.id.btnDetail)
        init {
            btnDetail.setOnClickListener {
                Toast.makeText(view.context,"${tvName.text} | Demo Function",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.name
        holder.tvBirthYear.text = student.birthYear.toString()
    }

}