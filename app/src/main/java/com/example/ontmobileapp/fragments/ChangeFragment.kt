package com.example.ontmobileapp.fragments


import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.annotation.RequiresApi

import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Group
import com.example.ontmobileapp.network.HttpRequest
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class ChangeFragment : Fragment() {
    private var groups = mutableListOf<Group>()
    private var dateSelect: String? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_change, container, false)
        val groupSpinner = root.findViewById<Spinner>(R.id.group_select_change_spinner)
        val selDateBtn = root.findViewById<Button>(R.id.date_text)
        val dateText = root.findViewById<EditText>(R.id.date_text)
        val adapter =
            ArrayAdapter(activity!!, android.R.layout.simple_spinner_dropdown_item, groups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        groupSpinner.adapter = adapter
        selDateBtn.setOnClickListener {
            var c: Calendar = Calendar.getInstance()
            var y = c.get(Calendar.YEAR)
            var m = c.get(Calendar.MONTH)
            var d = c.get(Calendar.DAY_OF_MONTH)
            var datePickerDialog: DatePickerDialog = DatePickerDialog(activity!!,DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                dateSelect = (y + m + d).toString()
            }, y, m, d)

        }

        /*var builder = AlertDialog.Builder(activity!!)
            var inflater: LayoutInflater = layoutInflater
            var view: View = inflater.inflate(R.layout.date_picker_show, null)
            builder.setView(view)*/



        return root
    }
}

