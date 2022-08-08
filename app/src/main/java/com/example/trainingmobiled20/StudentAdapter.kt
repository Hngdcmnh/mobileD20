package com.example.trainingmobiled20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return students.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.tvName.text = student.name
        holder.tvBirthYear.text = student.birthYear.toString()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName) as TextView
        val tvBirthYear: TextView = view.findViewById(R.id.tvBirthyear) as TextView
        val btDetail: TextView = view.findViewById(R.id.btDetail) as TextView
        init {
            btDetail.setOnClickListener {
                Toast.makeText(view.context,"${tvName.text} + ${tvBirthYear.text}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}