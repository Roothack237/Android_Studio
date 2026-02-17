package com.example.rootcesse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java
import kotlin.reflect.KClass




class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        val email = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val password = findViewById<EditText>(R.id.editTextNumberPassword2)
        val loginBtn = findViewById<Button>(R.id.button3)


        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)

        loginBtn.setOnClickListener {
            val userEmail = email.text.toString().trim()
            val userPassword = password.text.toString().trim()
            if (userEmail.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(this, "Fill all necessary informations", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)
            if (savedEmail == null) {
                Toast.makeText(
                    this,
                    "You don't have an account. Click the 'Don't have an account' button",
                    Toast.LENGTH_LONG
                ).show()
            } else if (userEmail == savedEmail && userPassword == savedPassword) {
                val gender = sharedPref.getString("gender", "")
                val intent = Intent(this, LandingActivity::class.java)
                intent.putExtra("gender", gender)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show()
            }
        }

        val goToSignup = findViewById<TextView>(R.id.tvGoToSignup)

        goToSignup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}