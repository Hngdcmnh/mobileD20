package com.example.trainingmobiled20

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.databinding.ItemBinding

class StudentAdapter(private val onItemClick:(Student,Int)-> Unit):RecyclerView.Adapter<StudentAdapter.ViewHolder>()  {
    private val students = ArrayList<Student>()


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(students[position])
    }

    override fun getItemCount(): Int {
        return students.size
    }
    class ViewHolder(private val binding: ItemBinding,private val onTitleClick:(Student,Int)->Unit):RecyclerView.ViewHolder(binding.root){
        fun bindData(item:Student){
            binding.apply {
                tvNameStudent.text = item.name
                tvYearStudent.text = item.year.toString()
                btnStudent.setOnClickListener {v->
                    Toast.makeText(v.context,tvNameStudent.text,Toast.LENGTH_SHORT).show()
                    onTitleClick(item,adapterPosition)

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),onItemClick

    )
    fun setData(data:List<Student>){
        students.clear()
        students.addAll(data)
        notifyDataSetChanged()
    }

}