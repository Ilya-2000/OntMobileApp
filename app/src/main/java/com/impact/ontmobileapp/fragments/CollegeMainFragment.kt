package com.impact.ontmobileapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.impact.ontmobileapp.MainActivity

import com.impact.ontmobileapp.R
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 */
class CollegeMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_college_main, container, false)
        val viewPager = root.findViewById<ViewPager>(R.id.college_vp)
        val tabLayout = root.findViewById<TabLayout>(R.id.tab_layout_college)
        (activity as? MainActivity)?.supportActionBar?.title = "О техникуме"





        if (viewPager != null) {
            val adapter = CollegeVpAdapter(childFragmentManager)
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)
            viewPager.offscreenPageLimit = 2
        }




        return root
    }

}

class CollegeVpAdapter internal constructor(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val count = 3
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = AboutCollegeFragment()
            1 -> fragment = ApplicantFragment()
            2 -> fragment = FeedbackFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return count
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var t: String? = null
        when (position) {
            0 -> t = "О техникуме"
            1 -> t = "Абитуриенту"
            2 -> t = "Обратная связь"
        }
        return t
    }


}
