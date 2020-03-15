package com.impact.ontmobileapp.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.impact.ontmobileapp.MainActivity

import com.impact.ontmobileapp.R
import com.impact.ontmobileapp.adapters.ScheduleShowRvAdapter
import com.impact.ontmobileapp.models.Global

/**
 * A simple [Fragment] subclass.
 */
class ShowScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_show_schedule, container, false)
        val navController = findNavController()
        val recyclerView = root.findViewById<RecyclerView>(R.id.show_schedule_rv)
        val closeFab = root.findViewById<FloatingActionButton>(R.id.close_schedule_fab)
        var adapter = ScheduleShowRvAdapter(Global.scheduleList)
        recyclerView.adapter = adapter
        Log.d("schedule", Global.scheduleList.size.toString())
        closeFab.setOnClickListener {
            navController.navigate(R.id.action_showScheduleFragment_to_navigation_tableFragment)
        }
        return root


    }



}
