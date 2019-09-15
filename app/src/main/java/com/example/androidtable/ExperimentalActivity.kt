package com.example.androidtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_map.*

class ExperimentalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experimental)

        var nameArray: Array<String> = arrayOf("McDonald's", "Mr.Panino's", "Mel's Diner", "Mongolian Grill")
        var infoArray: Array<String> = arrayOf("Classic fast food", "Such authentic chinese food", "Breakfast style diner", "Premium asian food")
        var imageArray: Array<Int> = arrayOf(R.drawable.mcd, R.drawable.pan,R.drawable.mel, R.drawable.mong)

        var whatever = CustomListAdapter(this, nameArray, infoArray, imageArray)
        var listView = findViewById<ListView>(R.id.listView)

        listView.adapter = whatever

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
