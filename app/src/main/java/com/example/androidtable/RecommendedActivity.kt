package com.example.androidtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.ListView
import android.widget.ArrayAdapter

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.ArrayList

import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_map.*

class RecommendedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommended)

        /*
        var mListView = findViewById<ListView>(R.id.listView)
        val API_KEY = "AIzaSyDp9SkWjsx5tV-9kJ6y6FC02SJCWlAE3so"

        val PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place"

        val TYPE_AUTOCOMPLETE = "/autocomplete"
        val TYPE_DETAILS = "/details"
        val TYPE_SEARCH = "/nearbysearch"
        val OUT_JSON = "/json?"
        val LOG_TAG = "ListRest"

        var intent = getIntent()
        val longitude:String? = intent.getStringExtra("long")
        val latitude:String? = intent.getStringExtra("lat")

        var policy:StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var lng = longitude?.toDouble()
        var lat = latitude?.toDouble()
        var radius = 1000

        data class Place(public var reference:String, public var name:String){
            override fun toString():String{
                return name
            }
        }

        var list:ArrayList<Place>? = ArrayList<Place>()


        fun search(lat: Double?, lng: Double?, radius: Int?): ArrayList<Place>? {
            var resultList: ArrayList<Place>? = ArrayList()

            var conn: HttpURLConnection? = null
            val jsonResults = StringBuilder()
            try {
                val sb = StringBuilder(PLACES_API_BASE)
                sb.append(TYPE_SEARCH)
                sb.append(OUT_JSON)
                sb.append("location=$lat,$lng")
                sb.append("&radius=$radius")
                sb.append("&type=restaurant")
                sb.append("&key=$API_KEY")

                val url = URL(sb.toString())
                conn = url.openConnection() as HttpURLConnection
                val `in` = InputStreamReader(conn.getInputStream())

                var read: Int
                val buff = CharArray(1024)
                read = `in`.read(buff)
                while (read != -1) {
                    jsonResults.append(buff, 0, read)
                }
            } catch (e: MalformedURLException) {
                Log.e(LOG_TAG, "Error processing Places API URL", e)
                return resultList
            } catch (e: IOException) {
                Log.e(LOG_TAG, "Error connecting to Places API", e)
                return resultList
            } finally {
                if (conn != null) {
                    conn.disconnect()
                }
            }

            try {
                // Create a JSON object hierarchy from the results
                val jsonObj = JSONObject(jsonResults.toString())
                val predsJsonArray = jsonObj.getJSONArray("results")

                // Extract the descriptions from the results
                resultList = ArrayList<Place>(predsJsonArray.length())
                for (i in 0 until predsJsonArray.length()) {
                    val place = Place("","")
                    place.reference = predsJsonArray.getJSONObject(i).getString("reference")
                    place.name = predsJsonArray.getJSONObject(i).getString("name")
                    resultList.add(place)
                }
            } catch (e: JSONException) {
                Log.e(LOG_TAG, "Error processing JSON results", e)
            }

            return resultList
        }

        list = search(lat, lng, radius)

        if(list != null){
            var adapter= ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, list)
            mListView.adapter = adapter
        }

         */


        var nameArray: Array<String> = arrayOf("McDonald's", "Mr.Panino's", "Mel's Diner", "Mongolian Grill")
        var infoArray: Array<String> = arrayOf("Classic fast food", "Such authentic chinese food", "Breakfast style diner", "Premium asian food")
        var imageArray: Array<Int> = arrayOf(R.drawable.mcd, R.drawable.pan,R.drawable.mel, R.drawable.mong)

        var whatever = CustomListAdapter(this, nameArray, infoArray, imageArray)
        var listView = findViewById<ListView>(R.id.listView)

        listView.adapter = whatever

        var navbar = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        navbar.getMenu().findItem(R.id.recommendations).setChecked(true)

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


