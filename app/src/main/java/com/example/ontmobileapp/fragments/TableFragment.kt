package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.ontmobileapp.R
import com.example.ontmobileapp.adapters.SchedulePagerAdapter
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.Group
import com.example.ontmobileapp.network.HttpRequest
import kotlinx.android.synthetic.main.fragment_table.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class TableFragment : Fragment() {
    private var groups = mutableListOf<Group>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table, container, false)
        groups = Global.groupsGlobal


        val viewPager = view.findViewById<ViewPager>(R.id.schedule_view_pager)

        if (viewPager != null) {
            val adapter = SchedulePagerAdapter(childFragmentManager)
            viewPager.adapter = adapter
        }
     //this.schedule_tabs.setupWithViewPager(viewPager)
        return view
    }


}
