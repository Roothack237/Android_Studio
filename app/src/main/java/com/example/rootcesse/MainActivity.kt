package com.example.rootcesse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat




class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = findViewById<EditText>(R.id.editTextNumberPassword)
        val phone = findViewById<EditText>(R.id.editTextPhone)
        val name = findViewById<EditText>(R.id.editTextText)
        val male = findViewById<RadioButton>(R.id.rbmale)
        val female = findViewById<RadioButton>(R.id.rbmale)
        val button =  findViewById<Button>(R.id.button)

        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val editor = sharedPref.edit()

        button.setOnClickListener{
            val username = name.text.toString().trim()
            val userEmail = email.text.toString().trim()
            val userPassword = password.text.toString().trim()
            val userPhone = phone.text.toString().trim()
            val radioGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
            val selectedId = radioGroup.checkedRadioButtonId
            if (username.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty() || userPhone.isEmpty() || selectedId == -1){
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
           val gender = if (male.isChecked) "Male" else "Female"


            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                selectedRadioButton.text.toString()
            }
            val title = if (gender == "Female") {
                "Mrs"
            }else{
                "Mr"
            }
            editor.putString("title", title)
            editor.putString("username", username)
            editor.putString("email", userEmail)
            editor.putString("password", userPassword)
            editor.putString("phone", userPhone)
            editor.putString("gender", gender)
            editor.apply()

            val intent = Intent(this, LandingActivity::class.java)
            intent.putExtra("WELCOME_NAME", "$title $username")
            startActivity(intent)


        }
        val haveAccount = findViewById<TextView>(R.id.account)
        haveAccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}