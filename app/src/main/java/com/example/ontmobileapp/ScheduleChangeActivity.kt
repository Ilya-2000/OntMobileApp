package com.example.ontmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.example.ontmobileapp.adapters.SchedulePagerAdapter
import kotlinx.android.synthetic.main.activity_schedule_change.*

class ScheduleChangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_change)
        val viewPager = findViewById<ViewPager>(R.id.schedule_view_pager)
        

        if (viewPager != null) {
            val adapter = SchedulePagerAdapter(supportFragmentManager)
            viewPager.adapter = adapter
        }
        this.schedule_tabs.setupWithViewPager(viewPager)

    }
}
