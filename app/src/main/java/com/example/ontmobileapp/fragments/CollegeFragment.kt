package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

import com.example.ontmobileapp.R

/**
 * A simple [Fragment] subclass.
 */
class CollegeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_college, container, false)
        /*val vp = view.findViewById<ViewPager>(R.id.college_vp)

        if (vp != null) {
            val adapter = CollegePagerAdapter(childFragmentManager)
            vp.adapter = adapter
        }*/
        return view
    }


}

/*class CollegePagerAdapter internal constructor(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 2
    private val titles = mutableListOf<Int>(R.string.tab_schedule_one, R.string.tab_schedule_two)
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = ApplicantFragment()
            1 -> fragment = FeedbackFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return count
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var t: String? = null
        when (position) {
            0 -> t = "Абитуриенту"
            1 -> t = "Обратная связь"
        }
        return t
    }


}*/
