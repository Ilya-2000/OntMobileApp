package com.example.ontmobileapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
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
}
