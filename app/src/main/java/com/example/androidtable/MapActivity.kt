package com.example.androidtable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient



class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        var mapBox = findViewById<WebView>(R.id.mapbox)
        mapBox.settings.javaScriptEnabled = true
        mapBox.loadUrl("http://www.google.com/maps")
        mapBox.webViewClient = WebViewClient()

    }
}
