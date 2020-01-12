package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.ListFragment

import com.example.ontmobileapp.R
import com.example.ontmobileapp.adapters.NewsListViewAdapter
import com.example.ontmobileapp.models.News
import com.example.ontmobileapp.network.HttpGetNews
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : ListFragment() {
    private var listNews = mutableListOf<News>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_news, container, false)
        //val listView: ListView = view.findViewById(R.id.news_lv)
        val httpGetNews = HttpGetNews()
        httpGetNews.execute()
        listNews = httpGetNews.get()

        //val adapter = NewsListViewAdapter(activity!!,listNews)
        //listView.adapter = adapter

       /* Thread(Runnable {
            activity?.runOnUiThread {
                listView.adapter = adapter
            }
        }).start()*/




        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

            val adapter = NewsListViewAdapter(activity!!, listNews)
            listAdapter = adapter






    }


}
