package com.example.androidtable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        window.setBackgroundDrawableResource(R.drawable.background)

        var fbAuth = FirebaseAuth.getInstance()

        var passwordBox = findViewById<EditText>(R.id.password)
        var emailBox = findViewById<EditText>(R.id.email)
        var rememberBox = findViewById<CheckBox>(R.id.remember)
        var loginButton = findViewById<Button>(R.id.login)
        var signupButton = findViewById<Button>(R.id.signup)

        loginButton.setOnClickListener {
            var password = passwordBox.text.toString().trim()
            var email = emailBox.text.toString().trim()
            var remember = rememberBox.isChecked
            
            fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{task: Task<AuthResult> ->
                if(task.isSuccessful){
                    Toast.makeText(this@MainActivity, "Login Completed", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MapActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, "Login failed", Toast.LENGTH_SHORT).show()
                }

            }


        }

        signupButton.setOnClickListener{
            var password = passwordBox.text.toString().trim()
            var email = emailBox.text.toString().trim()

            fbAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task: Task<AuthResult> ->
                if(task.isSuccessful) {
                    Toast.makeText(this@MainActivity,"Registration Successful",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MapActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                } else{
                    Toast.makeText(this@MainActivity, "Registration Failed", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }


}
