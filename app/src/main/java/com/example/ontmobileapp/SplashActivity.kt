package com.example.ontmobileapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.ontmobileapp.models.Global
import com.example.ontmobileapp.models.Group
import com.example.ontmobileapp.models.News
import com.example.ontmobileapp.network.HttpGetNews
import com.example.ontmobileapp.network.HttpRequest
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class SplashActivity : AppCompatActivity() {
    private var groups = mutableListOf<Group>()
    private var listNews = mutableListOf<News>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getGroup()
        getNews()
        Global.groupsGlobal = groups

        var handler = Handler().postDelayed(Runnable {
            checkStart()
        }, 2500)
    }

    fun checkStart() {
        var shared = getSharedPreferences("fstart", Context.MODE_PRIVATE)
        var isVisited: Boolean = shared.getBoolean("visited", false)
        if (!isVisited) {
            startActivity(Intent(this,SettingsActivity::class.java))
            var editor = shared.edit()
            editor.putBoolean("visited", true)
            editor.apply()
        } else {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    private fun getGroup() {
        try {
            val httpRequest = HttpRequest()
            //val groupsList = mutableListOf<Group>()
            httpRequest.execute("http://api.ontvkr.ru/gruppa/")
            val result: String = httpRequest.get()
            if(result != null) {
                var jsonObject: JSONObject = JSONObject(result)
                var jsonArray: JSONArray = jsonObject.getJSONArray("records")


                var i = 0
                while ( i < jsonArray.length()) {
                    var jsonObject1: JSONObject = jsonArray.getJSONObject(i)
                    var group = Group()
                    group.name = jsonObject1.getString("nomer")
                    groups.add(group)
                    i++
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            val toast = Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }

    }
    private fun getNews() {
        try {
            val httpGetNews = HttpGetNews()
            httpGetNews.execute()
            listNews = httpGetNews.get()
            Global.listNewsGlobal = listNews
        } catch (e: Exception) {
            e.message
        }
    }
}
