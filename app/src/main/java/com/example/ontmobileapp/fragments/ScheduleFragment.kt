package com.example.ontmobileapp.fragments


import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Spinner

import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Schedule
import com.example.ontmobileapp.network.HttpRequest
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFragment : Fragment() {
    var schedules = mutableListOf<Schedule>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_schedule, container, false)
        val groupSpinner = root.findViewById<Spinner>(R.id.group_schedule_spinner)
        val dateSpinner = root.findViewById<Spinner>(R.id.date_schedule_spinner)
        val showBtn = root.findViewById<Button>(R.id.show_schedule_btn)


        showBtn.setOnClickListener {
            
        }
        return root
    }

    private fun getSchedule(url: String) {
        try {
        val httpRequest = HttpRequest()
        httpRequest.execute(url)
        val result: String = httpRequest.get()
        if (result != null) {
            var jsonObject: JSONObject = JSONObject(result)
            var jsonArray: JSONArray = jsonObject.getJSONArray("records")


            var i = 0

            while (i < jsonArray.length()) {
                var jsonObject1: JSONObject = jsonArray.getJSONObject(i)
                var schedule = Schedule()

                schedule.cabinet = jsonObject1.getString("id_kab")
                schedule.group = jsonObject1.getString("gruppa")
                schedule.type = jsonObject1.getString("tip")
                schedule.lessonName = jsonObject1.getString("disciplina")
                schedule.day = jsonObject1.getString("den")
                schedule.lessonNum = jsonObject1.getString("para")

                schedules.add(schedule)

                i++
            }
        }
    } catch (e: Exception) {
            e.message
        }
    }


}
