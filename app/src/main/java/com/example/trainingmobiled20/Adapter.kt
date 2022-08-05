package com.example.trainingmobiled20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val students: ArrayList<Student>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = students[position]
        holder.tvName.text=currentItem.name
        holder.tvAge.text=currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName) as TextView
        val tvAge: TextView = itemView.findViewById(R.id.tvAge) as TextView
    }
}
