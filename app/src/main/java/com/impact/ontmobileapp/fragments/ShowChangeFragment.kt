package com.impact.ontmobileapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.impact.ontmobileapp.R
import com.impact.ontmobileapp.adapters.ChangeShowRvAdapter
import com.impact.ontmobileapp.models.Global

/**
 * A simple [Fragment] subclass.
 */
class ShowChangeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_show_change, container, false)
        val closeFab = root.findViewById<FloatingActionButton>(R.id.close_change_fab)
        val recyclerView = root.findViewById<RecyclerView>(R.id.change_rv)
        var adapter = ChangeShowRvAdapter(Global.changesList)
        val navController = findNavController()
        Log.d("ch", Global.changesList.size.toString())
        recyclerView.adapter = adapter
        Log.d("a", recyclerView.size.toString())
        Log.d("list", Global.changesList.get(0).toString())

        closeFab.setOnClickListener {
            navController.navigate(R.id.action_showChangeFragment_to_navigation_tableFragment)

        }
        return root
    }

}
