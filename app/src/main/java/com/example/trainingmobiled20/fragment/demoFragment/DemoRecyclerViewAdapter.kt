package com.example.trainingmobiled20.fragment.demoFragment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.R
import com.example.trainingmobiled20.data.Student
import com.google.android.material.divider.MaterialDivider

class DemoRecyclerViewAdapter(private val studentList: List<Student>) :
    RecyclerView.Adapter<DemoRecyclerViewAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun getItemCount(): Int = studentList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvYearOfBirth: TextView = view.findViewById(R.id.tvYearOfBird)
        val btnDetail: AppCompatButton = view.findViewById(R.id.btnDetail)
        val divider: MaterialDivider = view.findViewById(R.id.divider)
        val expandContent: RelativeLayout = view.findViewById(R.id.expandContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_demo, parent, false)

        context = parent.context

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setContent(holder, position)
        setOnclick(holder, position)
    }

    private fun setContent(holder: ViewHolder, position: Int) {
        val student: Student = studentList[position]

        val isExpandable: Boolean = student.expandable
        holder.apply {
            expandContent.visibility = if (isExpandable) View.VISIBLE else View.GONE
            divider.visibility = if (isExpandable) View.VISIBLE else View.GONE

            tvName.text = student.name
            tvYearOfBirth.text = student.yearOfBirth.toString()
        }
    }

    private fun setOnclick(holder: ViewHolder, position: Int) {
        holder.btnDetail.setOnClickListener {
            showStudentDetailInfo(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showStudentDetailInfo(position: Int) {
        Toast.makeText(context, "Hiển thị thông tin chi tiết!", Toast.LENGTH_SHORT).show()
        studentList[position].expandable = !studentList[position].expandable
        notifyItemChanged(position)
    }
}