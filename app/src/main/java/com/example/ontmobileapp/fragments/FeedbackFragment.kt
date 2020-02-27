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
class FeedbackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_feedback, container, false)
        val webView = root.findViewById<WebView>(R.id.callback_web_view)
        webView.loadUrl("http://www.nt-orsk.ru/index.php/2017-01-05-14-06-48")
        //https://docs.google.com/forms/d/e/1FAIpQLSe9cjxh_IwyNmZn4SMA2r8Oe1gjrlDXiFYYOLlOetlchT6XWg/viewform
        return root
    }

}
