package com.example.ontmobileapp.adapters

import androidx.annotation.IntegerRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ontmobileapp.R
import com.example.ontmobileapp.fragments.ChangeFragment
import com.example.ontmobileapp.fragments.ScheduleFragment

class SchedulePagerAdapter internal constructor(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 2
    private val titles = mutableListOf<Int>(R.string.tab_schedule_one, R.string.tab_schedule_two)
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = ScheduleFragment()
            1 -> fragment = ChangeFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return count
    }

    override fun getPageTitle(position: Int): CharSequence? {
        //val t: String?
        /*when (position) {
            0 -> t = "Расписание"
            1 -> t = "Замены"
        }*/
        return titles.get(position).toString()
    }


}