package com.example.ontmobileapp.network

import android.os.AsyncTask
import com.example.ontmobileapp.models.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException

class HttpGetNews: AsyncTask<Void, Void, MutableList<News>>() {
        var title: String? = null
        private val list = mutableListOf<News>()
        override fun doInBackground(vararg p0: Void?): MutableList<News>? {
            var document: Document?
            var newsMassive: Elements?
            try {
                
                document = Jsoup.connect("http://nt-orsk.ru/index.php?start=1").get()

                if(document != null) {
                    title = document.title()
                    newsMassive = document.select("div[class=blog-featured]")
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
