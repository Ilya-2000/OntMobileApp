package com.example.ontmobileapp.fragments


import android.content.Intent
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
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ontmobileapp.OpenNewsActivity

import com.example.ontmobileapp.R
import com.example.ontmobileapp.adapters.NewsListViewAdapter
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.News
import com.example.ontmobileapp.network.HttpGetNews
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {
    private var listNews = mutableListOf<News>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val listView: ListView = root.findViewById(R.id.lv)
        var urlNews : String
        var headerNews: String
        val httpGetNews = HttpGetNews()
        httpGetNews.execute()
        listNews = httpGetNews.get()
        val adapter = NewsListViewAdapter(activity!!, listNews)
        listView.adapter = adapter
        val navController = findNavController()

        listView.setOnItemClickListener { adapterView, view, posititon, id ->
            val global = Global
            global.newsUrl = listNews.get(posititon).link
            global.newsImg = listNews.get(posititon).image
            global.newsTitle = listNews.get(posititon).title
            navController.navigate(R.id.openNewsActivity)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }




}
