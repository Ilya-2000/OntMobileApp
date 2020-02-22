package com.example.ontmobileapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Schedule

class ScheduleShowRvAdapter (var items: List<Schedule>):
    RecyclerView.Adapter<ScheduleShowRvAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )= ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.schedule_common_item, parent, false))


    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(items[position])
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var numberLesson = itemView.findViewById<TextView>(R.id.num_lesson_schedule_text)
        private var discipline = itemView.findViewById<TextView>(R.id.discipline_schedule_text)
        private var cabinet = itemView.findViewById<TextView>(R.id.cabinet_schedule_text)
        fun  bind(item: Schedule) {
            numberLesson.text = item.lessonNum
            discipline.text = item.lessonName
            cabinet.text = item.cabinet
        }
    }
}