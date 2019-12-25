package com.example.ontmobileapp.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ontmobileapp.R

class CollegeFragment : Fragment() {

    companion object {
        fun newInstance() = CollegeFragment()
    }

    private lateinit var viewModel: CollegeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.college_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CollegeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
