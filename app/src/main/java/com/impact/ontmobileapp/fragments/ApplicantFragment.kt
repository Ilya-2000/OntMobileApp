package com.impact.ontmobileapp.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

import com.impact.ontmobileapp.R

/**
 * A simple [Fragment] subclass.
 */
class ApplicantFragment : Fragment() {
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_applicant, container, false)
        val webView = root.findViewById<WebView>(R.id.applicant_webview)
        mHandler = Handler()
        getWeb(webView)


        return root
    }
    private fun getWeb(webView: WebView) {
        mHandler.postDelayed(Runnable {
            webView.loadUrl("http://nt-orsk.ru/index.php/2017-01-05-13-48-18")
        }, 500)
    }


}
