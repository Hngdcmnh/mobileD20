package com.example.trainingmobiled20

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.databinding.ItemStudentBinding

class StudentsAdapter(private val mStudents: List<Student>) :
    RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: ItemStudentBinding) : RecyclerView.ViewHolder(itemView.root) {
        val nameTextView = itemView.studentName
        val chitietButton = itemView.chiTietButton
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val studentView = ItemStudentBinding.inflate(inflater, parent, false)
        return ViewHolder(studentView)
    }

    override fun onBindViewHolder(viewHolder: StudentsAdapter.ViewHolder, position: Int) {
        val student: Student = mStudents.get(position)
        val textView = viewHolder.nameTextView
        textView.setText(student.name)
        val button = viewHolder.chitietButton
        button.text = "Chi tiết"
        button.setOnClickListener { v ->
            Toast.makeText(v.context, student.name + " | Demo function", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return mStudents.size
    }
}