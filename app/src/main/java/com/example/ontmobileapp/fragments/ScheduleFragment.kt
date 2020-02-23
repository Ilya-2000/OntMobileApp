package com.example.ontmobileapp.fragments


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.navigation.fragment.findNavController

import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.Group
import com.example.ontmobileapp.models.Schedule
import com.example.ontmobileapp.network.HttpRequest
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFragment : Fragment(), AdapterView.OnItemSelectedListener {
    var schedules = mutableListOf<Schedule>()
    private var groups = mutableListOf<Group>()
    private var dateSelect: String? = null
    private var groupSelect: String? = null
    private var dateList = mutableListOf<String>("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_schedule, container, false)
        groups = Global.groupsGlobal
        val navController = findNavController()
        val groupSpinner = root.findViewById<Spinner>(R.id.group_schedule_spinner)
        val dateSpinner = root.findViewById<Spinner>(R.id.date_schedule_spinner)
        val showBtn = root.findViewById<Button>(R.id.show_schedule_btn)

        val adapter =
            ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, groups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        groupSpinner.adapter = adapter
        groupSpinner.onItemSelectedListener = this
        groupSpinner.setSelection(Global.posGroup!!)

        val adapterDateSpinner =
            ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, dateList)
        adapterDateSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dateSpinner.adapter = adapterDateSpinner
        dateSpinner.onItemSelectedListener = this


        showBtn.setOnClickListener {
            getSchedule("http://api.ontvkr.ru/raspisanie/search.php?s=$groupSelect&&p=$dateSelect")
            Global.scheduleList = schedules
            navController.navigate(R.id.showScheduleFragment)

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

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        when(parent!!.id) {
            R.id.group_schedule_spinner -> {
                groupSelect = groups.get(position).name.toString()
                Toast.makeText(activity, groupSelect, Toast.LENGTH_LONG).show()
            }
            R.id.date_schedule_spinner -> {
                dateSelect = dateList.get(position)
            }
        }

    }


}
