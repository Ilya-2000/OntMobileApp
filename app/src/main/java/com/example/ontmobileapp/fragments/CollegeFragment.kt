package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

import com.example.ontmobileapp.R

/**
 * A simple [Fragment] subclass.
 */
class CollegeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_college, container, false)
        val webView = view.findViewById<WebView>(R.id.callback_web_view)
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSe9cjxh_IwyNmZn4SMA2r8Oe1gjrlDXiFYYOLlOetlchT6XWg/viewform")
        return view
    }


}
