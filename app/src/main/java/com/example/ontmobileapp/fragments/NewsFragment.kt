package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.example.ontmobileapp.R
import com.example.ontmobileapp.adapters.NewsListViewAdapter
import com.example.ontmobileapp.models.News
import com.example.ontmobileapp.network.HttpGetNews

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {
    private var listNews = mutableListOf<News>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_news, container, false)

        val listView: ListView = view.findViewById(R.id.news_lv)
        /*val httpGetNews = HttpGetNews()
        listNews = httpGetNews.get()*/
        listNews.add(0, News("abracadabra","http://nt-orsk.ru/images/banner/logo.png",
            "http://nt-orsk.ru/"))
        val adapter = NewsListViewAdapter(context!!,listNews)
        listView.adapter = adapter


        return view
    }


}
