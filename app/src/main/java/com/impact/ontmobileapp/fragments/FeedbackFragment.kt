package com.impact.ontmobileapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.impact.ontmobileapp.R
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 */
class FeedbackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_feedback, container, false)
        /*val webView = root.findViewById<WebView>(R.id.callback_web_view)
        webView.loadUrl("http://www.nt-orsk.ru/index.php/2017-01-05-14-06-48")*/
        //https://docs.google.com/forms/d/e/1FAIpQLSe9cjxh_IwyNmZn4SMA2r8Oe1gjrlDXiFYYOLlOetlchT6XWg/viewform
        val nameText = root.findViewById<TextInputEditText>(R.id.name_feedback_text)
        val emailText = root.findViewById<TextInputEditText>(R.id.email_feedback_text)
        val messageText = root.findViewById<TextInputEditText>(R.id.message_feedback_text)
        val lastNameText = root.findViewById<TextInputEditText>(R.id.last_name_feedback_text)
        return root
    }

}
