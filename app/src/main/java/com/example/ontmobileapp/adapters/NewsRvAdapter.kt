package com.example.ontmobileapp.adapters

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ontmobileapp.R
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.News
import com.example.ontmobileapp.models.Schedule
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import kotlinx.android.synthetic.main.news_item.view.*

class NewsRvAdapter(var context: Context, var items: List<News>, var navController: NavController): RecyclerView.Adapter<NewsRvAdapter.ViewHolder>() {
    private var listener: OnСlickListener? = null
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    fun setListener(listener: OnСlickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            val itemView = ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.news_item,
                    parent,
                    false
                )
            )
            return itemView
        } else {
            val itemView = ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_loading,
                    parent,
                    false
                )
            )
            return itemView
        }

    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            val global = Global
            global.newsUrl = items.get(position).link
            global.newsImg = items.get(position).image
            global.newsTitle = items.get(position).title
            navController.navigate(R.id.openNewsActivity)
        }
        //listener?.onClick()
    }


    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title = itemView.findViewById<TextView>(R.id.news_header_text)
        private var imageView = itemView.findViewById<ImageView>(R.id.news_img)


        fun  bind(item: News) {
            title.text = item.title

            Picasso.get()
                .load(item.image)
                .into(itemView.news_img)
        }
    }

    public interface OnСlickListener {
        fun onClick(position: Int)

    }

}


