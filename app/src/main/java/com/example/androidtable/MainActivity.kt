package com.example.androidtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        window.setBackgroundDrawableResource(R.drawable.background)

        var passwordBox = findViewById<EditText>(R.id.password)
        var emailBox = findViewById<EditText>(R.id.email)
        var rememberBox = findViewById<CheckBox>(R.id.remember)
        var loginButton = findViewById<Button>(R.id.login)
        var signupButton = findViewById<Button>(R.id.signup)

        loginButton.setOnClickListener {
            var password = passwordBox.text
            var email = emailBox.text
            var remember = rememberBox.isChecked

            //TODO: Verify with backend that user info is valid

            val intent = Intent(this, MapActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        signupButton.setOnClickListener{

        }
    }


}
