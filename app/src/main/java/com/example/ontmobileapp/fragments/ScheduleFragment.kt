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

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_schedule, container, false)
        val groupSpinner = root.findViewById<Spinner>(R.id.group_schedule_spinner)
        val dateSpinner = root.findViewById<Spinner>(R.id.date_schedule_spinner)
        val showBtn = root.findViewById<Button>(R.id.show_schedule_btn)


        showBtn.setOnClickListener {
            getDialog("ага", "угу")
        }
        return root
    }



    private fun getDialog(date: String, group: String) {
        var dialog = Dialog(activity!!, R.style.MyTheme)
        dialog.setContentView(R.layout.out_schedule)
        var layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT

        dialog.window!!.setLayout(width, height)
        dialog.window!!.attributes = layoutParams

        dialog.show()
    }


}
