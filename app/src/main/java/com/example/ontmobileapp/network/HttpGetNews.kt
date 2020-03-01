package com.example.ontmobileapp.network

import android.os.AsyncTask
import com.example.ontmobileapp.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException

class HttpGetNews: AsyncTask<Int, Void, MutableList<News>>() {
    var title: String? = null
        private val list = mutableListOf<News>()
        var count: Int = 0
        override fun doInBackground(vararg p0: Int?): MutableList<News>? {
            var document: Document?
            var newsMassive: Elements?
            try {

                document = Jsoup.connect("http://nt-orsk.ru/index.php/novosti?start=$count").get()

                if(document != null) {
                    title = document.title()
                    newsMassive = document.select("div[class=span8 sidebar_right]")
                    val newsData = newsMassive.select("div[itemprop=blogPost]")

                    for(i: Int in 0 until newsData.size) {
                        val newsTitle = newsData.get(i).select("a").text()
                        val imgNews = "http://nt-orsk.ru/" + newsData.get(i).select("img").attr("src").toString()
                        val linkNews = "http://nt-orsk.ru/" + newsData.get(i).select("a").attr("href").toString()
                        list.add(News(newsTitle,imgNews, linkNews))
                    }
                } else {
                    title = "Error"
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }


            return list
        }
    }
