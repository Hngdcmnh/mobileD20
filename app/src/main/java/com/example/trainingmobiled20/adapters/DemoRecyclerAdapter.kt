package com.example.trainingmobiled20.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.databinding.ItemRecyclerViewBinding
import com.example.trainingmobiled20.model.Student

class DemoRecyclerAdapter(
    private val dataList: List<Student>,
    private val onItemClicked: (Student) -> Unit
) : RecyclerView.Adapter<DemoRecyclerAdapter.DemoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
        return DemoViewHolder(
            ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    inner class DemoViewHolder(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.btItemGoToDetail.setOnClickListener {
                onItemClicked(student)
            }
            binding.tvItemName.text = student.name
            binding.tvItemSubName.text = student.dob
        }
    }
}