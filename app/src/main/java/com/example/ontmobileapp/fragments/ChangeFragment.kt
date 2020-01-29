package com.example.ontmobileapp.fragments


import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.annotation.RequiresApi

import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Change
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.Group
import com.example.ontmobileapp.network.HttpRequest
import kotlinx.android.synthetic.main.out_change.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class ChangeFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var groups = mutableListOf<Group>()
    private var changes = mutableListOf<Change>()
    private var dateSelect: String? = null
    private var groupSelect: String? = null
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_change, container, false)
        var cal: Calendar = Calendar.getInstance()
        var year = cal.get(Calendar.YEAR)
        var month = cal.get(Calendar.MONTH)
        var day = cal.get(Calendar.DAY_OF_MONTH)
        val groupSpinner = root.findViewById<Spinner>(R.id.group_select_change_spinner)
        val selDateBtn = root.findViewById<Button>(R.id.change_btn)
        val dateText = root.findViewById<TextView>(R.id.date_text)
        val showChangeBtn = root.findViewById<Button>(R.id.show_change_btn)

        groups = Global.groupsGlobal
        dateSelect = year.toString() + "-" + (month + 1).toString() + "-" + day.toString()
        dateText.text = dateSelect
        val adapter =
            ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, groups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        groupSpinner.adapter = adapter
        groupSpinner.onItemSelectedListener = this
        groupSpinner.setSelection(Global.posGroup!!)

        selDateBtn.setOnClickListener {
            var c: Calendar = Calendar.getInstance()
            var y = c.get(Calendar.YEAR)
            var m = c.get(Calendar.MONTH)
            var d = c.get(Calendar.DAY_OF_MONTH)
            var datePickerDialog = DatePickerDialog(activity!!,DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                dateSelect = year.toString() + "-" + (month + 1).toString() + "-" + day.toString()
                dateText.text = dateSelect
            }, y, m, d)
            datePickerDialog.show()

        }

        /*var builder = AlertDialog.Builder(activity!!)
            var inflater: LayoutInflater = layoutInflater
            var view: View = inflater.inflate(R.layout.date_picker_show, null)
            builder.setView(view)*/

        showChangeBtn.setOnClickListener {
            getChangesSchedule("http://api.ontvkr.ru/izmenenia/search.php?s=$dateSelect&p=$groupSelect")
            getDialog(dateSelect!!,groupSelect!!)
            var toast = Toast.makeText(activity!!,dateSelect + groupSelect, Toast.LENGTH_LONG).show()
        }



        return root
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        groupSelect = groups.get(position).name.toString()
        Toast.makeText(activity, groupSelect, Toast.LENGTH_LONG).show()
    }

    private fun getChangesSchedule(stringUrl: String) {
        try {

            val httpRequest = HttpRequest()
            httpRequest.execute(stringUrl)
            val result: String = httpRequest.get()
            if(result != null) {
                var jsonObject: JSONObject = JSONObject(result)
                var jsonArray: JSONArray = jsonObject.getJSONArray("records")


                var i = 0

                while ( i < jsonArray.length()) {
                    var jsonObject1: JSONObject = jsonArray.getJSONObject(i)
                    var change = Change()
                    change.id = jsonObject1.getString("id")
                    change.cabinet = jsonObject1.getString("kabinet")
                    change.date = jsonObject1.getString("data")
                    change.reason = jsonObject1.getString("prichina")
                    change.teacher = jsonObject1.getString("teacher_kto")
                    change.group = jsonObject1.getString("gruppa")
                    change.lessonNum = jsonObject1.getString("para")
                    changes.add(change)

                    i++
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    private fun getDialog(date: String, group: String) {
        var dialog = Dialog(activity!!,R.style.MyTheme)
        dialog.setContentView(R.layout.out_change)
        var layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT

        dialog.window!!.setLayout(width,height)
        dialog.window!!.attributes = layoutParams
        ///////////////////////
        val groupText = dialog.group_show_change_text
        val dateText = dialog.date_show_change_text
        val firstLesson = dialog.first_lesson_show_change_text
        val secondLesson = dialog.two_lesson_show_change_text
        val thirdLesson = dialog.three_lesson_show_change_text
        val fourLesson = dialog.four_lesson_show_change_text
        val fiveLesson = dialog.five_lesson_show_change_text
        val sixLesson = dialog.six_lesson_show_change_text
        val sevenLesson = dialog.seven_lesson_show_change_text

        val firstCabinet = dialog.first_cabinet_show_change_text
        val secondCabinet = dialog.two_cabinet_show_change_text
        val thirdCabinet = dialog.three_cabinet_show_change_text
        val fourCabinet = dialog.four_cabinet_show_change_text
        val fiveCabinet = dialog.five_cabinet_show_change_text
        val sixCabinet = dialog.six_cabinet_show_change_text
        val sevenCabinet = dialog.seven_cabinet_show_change_text

        val firstSub = dialog.first_subgroup_show_change_text
        val twoSub = dialog.two_subgroup_show_change_text
        val thirdSub = dialog.three_subgroup_show_change_text
        val fourSub = dialog.four_subgroup_show_change_text
        val fiveSub = dialog.five_subgroup_show_change_text
        val sixSub = dialog.six_subgroup_show_change_text
        val sevenSub = dialog.seven_subgroup_show_change_text
        //////////////////////////
        groupText.text = group
        dateText.text = date

        for (i in changes) {
            if(i.lessonNum!!.contains("1")!!) {
                firstLesson.text = i.reason
                firstCabinet.text = i.cabinet
                firstSub.text = i.subGroup
            } else if(i.lessonNum!!.contains("2")!!) {
                secondLesson.text = i.reason
                secondCabinet.text = i.cabinet
                twoSub.text = i.subGroup
            } else if(i.lessonNum!!.contains("3")!!) {
                thirdLesson.text = i.reason
                thirdCabinet.text = i.cabinet
                thirdSub.text = i.subGroup
            } else if(i.lessonNum!!.contains("4")!!) {
                fourLesson.text = i.reason
                fourCabinet.text = i.cabinet
                fourSub.text = i.subGroup
            } else if(i.lessonNum!!.contains("5")!!) {
                fiveLesson.text = i.reason
                fiveCabinet.text = i.cabinet
                fiveSub.text = i.subGroup
            } else if(i.lessonNum!!.contains("6")!!) {
                sixLesson.text = i.reason
                sixCabinet.text = i.cabinet
                sixSub.text = i.subGroup
            } else if(i.lessonNum!!.contains("7")!!) {
                sevenLesson.text = i.reason
                sevenCabinet.text = i.cabinet
                sevenSub.text = i.subGroup
            }
        }


        dialog.show()
    }
}

