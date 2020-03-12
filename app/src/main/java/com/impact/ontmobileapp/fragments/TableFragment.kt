package com.impact.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.impact.ontmobileapp.MainActivity
import com.impact.ontmobileapp.R
import com.impact.ontmobileapp.adapters.SchedulePagerAdapter
import com.impact.ontmobileapp.models.Global
import com.impact.ontmobileapp.models.Group
import com.google.android.material.tabs.TabLayout

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
        (activity as? MainActivity)?.supportActionBar?.title = "Расписание"


        val viewPager = view.findViewById<ViewPager>(R.id.schedule_view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout_table)

        if (viewPager != null) {
            val adapter = SchedulePagerAdapter(childFragmentManager)
            viewPager.adapter = adapter
        }
        tabLayout.setupWithViewPager(viewPager)
     //this.schedule_tabs.setupWithViewPager(viewPager)
        return view
    }


}
