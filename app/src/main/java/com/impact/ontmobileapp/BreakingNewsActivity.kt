package com.impact.ontmobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.impact.ontmobileapp.models.BreakingNews
import kotlinx.android.synthetic.main.activity_breaking_news.view.*

class BreakingNewsActivity : AppCompatActivity() {
    private var breakingNewsList = mutableListOf<BreakingNews>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breaking_news)
        var toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Уведомления"
        val recyclerView = findViewById<RecyclerView>(R.id.breaking_news_rv)
        val emptyText = findViewById<TextView>(R.id.empty_breaking_text)

        if (breakingNewsList.isEmpty()) {
            emptyText.visibility = View.VISIBLE
        } else {
            emptyText.visibility = View.GONE
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val menuItem: MenuItem = menu!!.findItem(R.id.notification_menu_item)
        menuItem.setVisible(false)

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.settings_item_menu -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                finish()
                Log.d("menu", "click")
            }
            R.id.about_us_menu_item -> {
                startActivity(Intent(this, AboutActivity::class.java))

            }

        }
        return super.onOptionsItemSelected(item)
    }
}
