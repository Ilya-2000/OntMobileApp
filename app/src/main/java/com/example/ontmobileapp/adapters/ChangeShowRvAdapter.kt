package com.example.ontmobileapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Change

class ChangeShowRvAdapter (var items: List<Change>):
    RecyclerView.Adapter<ChangeShowRvAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )= ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.change_item, parent, false))


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var numberLesson = itemView.findViewById<TextView>(R.id.number_change_item)
        private var discipline = itemView.findViewById<TextView>(R.id.lesson_change_item)
        private var cabinet = itemView.findViewById<TextView>(R.id.cabinet_change_item)
        private var type = itemView.findViewById<TextView>(R.id.subgroup_change_item)

        fun  bind(item: Change) {
            numberLesson.text = item.lessonNum
            discipline.text = item.reason
            cabinet.text = item.cabinet
            type.text = item.subGroup
        }
    }


}