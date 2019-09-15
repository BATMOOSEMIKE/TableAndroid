package com.example.androidtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_map.*

class ExperimentalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experimental)

        var navbar = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        navbar.getMenu().findItem(R.id.experimental).setChecked(true)

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
