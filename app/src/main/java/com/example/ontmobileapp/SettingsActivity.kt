package com.example.ontmobileapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.Group

class SettingsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var groups = mutableListOf<Group>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val spinner = findViewById<Spinner>(R.id.group_settings_spinner)
        val saveBtn = findViewById<Button>(R.id.save_set_btn)
        groups = Global.groupsGlobal

        saveBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, groups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        spinner.setSelection(Global.posGroup!!)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var selGroup = groups.get(position).name.toString()
        val sharedPreferences = getSharedPreferences("settingsgroup",Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putInt("grouppos",position)
        editor.putString("group",selGroup)
        editor.apply()
    }
}
