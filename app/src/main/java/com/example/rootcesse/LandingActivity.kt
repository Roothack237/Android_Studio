package com.example.rootcesse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.landing)

        val welcomeText = findViewById<TextView>(R.id.textView2)
        val logout = findViewById<Button>(R.id.button6)
        val gender = intent.getStringExtra("gender")

        /*if (gender == "Female"){
            welcomeText.text = "Welcome Mrs"
        }else{
            welcomeText.text = "Welcome Mr"
        }*/

        val welcomeName = intent.getStringExtra("WELCOME_NAME")
        welcomeText.text = "Welcome $welcomeName"

        val tvWelcome = findViewById<TextView>(R.id.textView)
        tvWelcome.text = "Welcome to our page. I hope you will contact us soon."
        val imageView = findViewById<ImageView>(R.id.imageView2)
        imageView.setImageResource(R.drawable.dish2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        imageView3.setImageResource(R.drawable.dish3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        imageView4.setImageResource(R.drawable.dish4)
        val imageView1 = findViewById<ImageView>(R.id.imageView)
        imageView1.setImageResource(R.drawable.dish1)
        val button = findViewById<Button>(R.id.button6)
        button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        logout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}