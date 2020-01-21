package com.example.ontmobileapp.fragments


import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi

import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.Group
import com.example.ontmobileapp.network.HttpRequest
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class ChangeFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var groups = mutableListOf<Group>()
    private var dateSelect: String? = null
    private var groupSelect: String? = null

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
        groups = Global.groupsGlobal
        dateSelect = year.toString() + "-" + (month + 1).toString() + "-" + day.toString()
        dateText.text = dateSelect
        val adapter =
            ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, groups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        groupSpinner.adapter = adapter
        groupSpinner.onItemSelectedListener = this

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



        return root
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        groupSelect = groups.get(position).name.toString()
        Toast.makeText(activity, groupSelect, Toast.LENGTH_LONG).show()
    }
}

