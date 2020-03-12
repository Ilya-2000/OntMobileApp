package com.impact.ontmobileapp

import android.app.Dialog
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.impact.ontmobileapp.models.Global
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_open_news.*
import kotlinx.android.synthetic.main.full_img.*
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
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        val global = Global
        link = global.newsUrl
        header = global.newsTitle
        img =  global.newsImg
        val headerText = findViewById<TextView>(R.id.header_open_news)
        val imageView = findViewById<ImageView>(R.id.image_open_news)
        val descriptionText = findViewById<TextView>(R.id.description_open_news)
        headerText.text = header

        Picasso.get()
            .load(img)
            .into(imageView)
        imageView.setOnClickListener {
            getDialog(img!!)
        }
        val parse = PageParse(link, this)
        parse.execute()


    }

     fun getDialog(d: String) {
        var dialog = Dialog(this,R.style.MyTheme)
        dialog.setContentView(R.layout.full_img)
        var layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window!!.setLayout(width,height)
        dialog.window!!.attributes = layoutParams

        val image = dialog.imageView_full
        Picasso.get()
            .load(d)
            .into(image)
        dialog.show()
        image.setOnClickListener {
            image.setImageDrawable(null)
            dialog.cancel()
        }

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
