package com.example.ontmobileapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

import com.example.ontmobileapp.R
import com.example.ontmobileapp.adapters.NewsRvAdapter
import com.example.ontmobileapp.models.Global
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
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val navController = findNavController()
        val recyclerView: RecyclerView = root.findViewById(R.id.news_rv)
        var urlNews : String
        var headerNews: String
        listNews = Global.listNewsGlobal
        val adapter = NewsRvAdapter(activity!!, listNews, navController)
        recyclerView.adapter = adapter


        /*recyclerView.setOnItemClickListener { adapterView, view, posititon, id ->
            val global = Global
            global.newsUrl = listNews.get(posititon).link
            global.newsImg = listNews.get(posititon).image
            global.newsTitle = listNews.get(posititon).title
            navController.navigate(R.id.openNewsActivity)

            


        }*/

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }




}
