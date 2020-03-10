package com.example.ontmobileapp.fragments

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView

import com.example.ontmobileapp.R
import com.example.ontmobileapp.adapters.ChangeShowRvAdapter
import com.example.ontmobileapp.models.Global

/**
 * A simple [Fragment] subclass.
 */
class ShowChangeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_show_change, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.change_rv)
        var adapter = ChangeShowRvAdapter(Global.changesList)
        Log.d("ch", Global.changesList.size.toString())
        recyclerView.adapter = adapter
        Log.d("a", recyclerView.size.toString())
        return root
    }

}
