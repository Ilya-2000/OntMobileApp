package com.example.ontmobileapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.News
import com.squareup.picasso.Picasso

class NewsListViewAdapter(private val context: Context,
                          private val news: MutableList<News>): BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.news_item, parent, false)

        val img = rowView.findViewById<ImageView>(R.id.news_img)
        val title = rowView.findViewById<TextView>(R.id.news_header_text)
        val news = getItem(position) as News

        Picasso.get()
            .load(news.image)
            .error(R.drawable.ic_launcher_foreground)
            .into(img)

        title.text = news.title

        return rowView
    }

    override fun getItem(position: Int): Any {
        return news[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount(): Int {
        return news.size
    }
}