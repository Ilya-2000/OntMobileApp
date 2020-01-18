package com.example.ontmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.example.ontmobileapp.adapters.SchedulePagerAdapter
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.Group
import com.example.ontmobileapp.network.HttpRequest
import kotlinx.android.synthetic.main.activity_schedule_change.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class ScheduleChangeActivity : AppCompatActivity() {
    private var groups = mutableListOf<Group>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_change)
        getGroup()
        Global.groupsGlobal = groups


        val viewPager = findViewById<ViewPager>(R.id.schedule_view_pager)


        if (viewPager != null) {
            val adapter = SchedulePagerAdapter(supportFragmentManager)
            viewPager.adapter = adapter
        }
        this.schedule_tabs.setupWithViewPager(viewPager)

    }
    private fun getGroup() {
        try {
            val httpRequest = HttpRequest()
            //val groupsList = mutableListOf<Group>()
            httpRequest.execute("http://api.ontvkr.ru/gruppa/")
            val result: String = httpRequest.get()
            if (result != null) {
                var jsonObject: JSONObject = JSONObject(result)
                var jsonArray: JSONArray = jsonObject.getJSONArray("records")


                var i = 0
                while (i < jsonArray.length()) {
                    var jsonObject1: JSONObject = jsonArray.getJSONObject(i)
                    var group = Group()
                    group.name = jsonObject1.getString("nomer")
                    groups.add(group)
                    i++
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
