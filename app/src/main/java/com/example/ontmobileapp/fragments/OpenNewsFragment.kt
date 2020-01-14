package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.ontmobileapp.R

/**
 * A simple [Fragment] subclass.
 */
class OpenNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_open_news, container, false)
        val headerText = view.findViewById<TextView>(R.id.header_open_news)
        val descriptionText = view.findViewById<TextView>(R.id.description_open_news)
        val imageNews = view.findViewById<ImageView>(R.id.image_open_news)

        return view
    }


}
