package com.example.ontmobileapp.fragments


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.ontmobileapp.R
import com.example.ontmobileapp.SettingsActivity
import com.example.ontmobileapp.adapters.NewsRvAdapter
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.News
import com.example.ontmobileapp.network.HttpGetNews
import kotlinx.android.synthetic.main.fragment_news.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {
    private var listNews = mutableListOf<News>()
    private var listNewsLocal = mutableListOf<News>()
    private var count: Int = Global.newsCountLoad
    var isLoading: Boolean = false
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val navController = findNavController()
        val toolbar:androidx.appcompat.widget.Toolbar = root.findViewById(R.id.toolbar_news)
        setHasOptionsMenu(true)
        (activity as? AppCompatActivity)?.supportActionBar
        mHandler = Handler()
        val recyclerView: RecyclerView = root.findViewById(R.id.news_rv)
        recyclerView.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        var urlNews : String
        var headerNews: String
        listNews = Global.listNewsGlobal
        val adapter = NewsRvAdapter(activity!!, listNews, navController)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        setRecyclerViewScrollListener(recyclerView)




        /*recyclerView.setOnItemClickListener { adapterView, view, posititon, id ->
            val global = Global
            global.newsUrl = listNews.get(posititon).link
            global.newsImg = listNews.get(posititon).image
            global.newsTitle = listNews.get(posititon).title
            navController.navigate(R.id.openNewsActivity)
        }*/



        return root
    }
    private fun setRecyclerViewScrollListener(recyclerView: RecyclerView) {

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            private val lastVisibleItemPosition: Int
                get() = (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                if (!isLoading) {
                    if (totalItemCount == lastVisibleItemPosition + 1) {
                        showProgress()
                        mHandler.postDelayed(Runnable {
                        count += 5
                        Global.newsCountLoad = count
                        getNews(count)
                        recyclerView.adapter!!.notifyItemInserted(listNews.size - 1)
                        },500)

                        /*Log.d("listNews", "$listNews")
                        Log.d("countSize", "$count")
                        Log.d("listNewsSize", "${listNews.size}")
                        Toast.makeText(activity, "$count", Toast.LENGTH_LONG).show()*/
                    }
                }

            }
        })
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun getNews(i: Int) {
        try {
            val httpGetNews = HttpGetNews()
            httpGetNews.count = i
            httpGetNews.execute()
            listNewsLocal = httpGetNews.get()
            listNews.addAll(listNewsLocal)
            listNewsLocal.clear()
            hideProgress()
        } catch (e: Exception) {
            e.message
        }
    }
    fun showProgress() {
        progress_bar_news_layout.visibility = View.VISIBLE
    }
    fun hideProgress() {
        progress_bar_news_layout.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when (id) {
            R.id.settings_item_menu -> {
                startActivity(Intent(activity, SettingsActivity::class.java))
                Log.d("menu", "click")
            }
            R.id.about_us_menu_item -> startActivity(Intent(activity, AboutFragment::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
