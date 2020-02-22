package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.ontmobileapp.R
import com.example.ontmobileapp.adapters.ScheduleShowRvAdapter
import com.example.ontmobileapp.models.Global

/**
 * A simple [Fragment] subclass.
 */
class ShowScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_show_schedule, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.show_schedule_rv)
        var adapter = ScheduleShowRvAdapter(Global.scheduleList)
        recyclerView.adapter = adapter
        return root
    }


}
