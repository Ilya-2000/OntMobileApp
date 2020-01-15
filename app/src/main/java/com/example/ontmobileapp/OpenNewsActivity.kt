package com.example.ontmobileapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.ontmobileapp.models.Global
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_open_news.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException

class OpenNewsActivity : AppCompatActivity() {
    private var link: String? = null
    private var header: String? = null
    private var img: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_news)
        val global = Global
        link = global.newsUrl
        header = global.newsTitle
        img = global.newsImg
        val headerText = findViewById<TextView>(R.id.header_open_news)
        val imageView = findViewById<ImageView>(R.id.image_open_news)
        val descriptionText = findViewById<TextView>(R.id.description_open_news)

        headerText.text = header
        Picasso.get()
            .load(img)
            .into(imageView)
        val parse = PageParse(link, this)
        parse.execute()


    }
}

class PageParse(url: String?, private var activity: OpenNewsActivity) : AsyncTask<Void, Void, String>() {
    var urlString: String? = url
    var textSite: String? = null


    override fun doInBackground(vararg p0: Void?): String? {

        var document: Document?
        var elements: Elements?


        try {
            document = Jsoup.connect(urlString).get()
            if(document != null) {
                elements = document.select("div[itemprop=articleBody]")
                textSite = elements.text()
            }

        } catch (e: IOException) {

        }

        return textSite
    }

    override fun onPostExecute(result: String?) {
        activity.description_open_news.text = textSite
        super.onPostExecute(result)
    }
}
