package com.example.androidtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_map.*


class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        var mapBox = findViewById<WebView>(R.id.mapbox)
        mapBox.settings.javaScriptEnabled = true
        mapBox.loadUrl("http://www.google.com/maps")
        mapBox.webViewClient = WebViewClient()

        // handle the bottom navigation item click
        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            var intent = Intent(this, MapActivity::class.java)

            when(item.itemId){
                R.id.map -> intent = Intent(this, MapActivity::class.java)
                R.id.recommendations -> intent = Intent(this, RecommendedActivity::class.java)
                R.id.experimental -> intent = Intent(this, ExperimentalActivity::class.java)
            }

            startActivity(intent)

            return@setOnNavigationItemSelectedListener true
        }
    }
}
