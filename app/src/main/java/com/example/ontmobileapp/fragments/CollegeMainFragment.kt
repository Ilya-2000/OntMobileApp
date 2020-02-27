package com.example.ontmobileapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController

import com.example.ontmobileapp.R

/**
 * A simple [Fragment] subclass.
 */
class CollegeMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_college_main, container, false)
        val applicantBtn = root.findViewById<CardView>(R.id.applicant_btn)
        val feedbackBtn = root.findViewById<CardView>(R.id.feedback_btn)
        val navController = findNavController()

        applicantBtn.setOnClickListener {
            navController.navigate(R.id.action_navigation_college_to_applicantFragment)
        }

        feedbackBtn.setOnClickListener {
            navController.navigate(R.id.action_navigation_college_to_feedbackFragment)
        }
        return root
    }

}
