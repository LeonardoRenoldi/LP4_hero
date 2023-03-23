package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{

            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            val sharedPreferences = getSharedPreferences("MY_PRE",Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("EMAIL", email)
            editor.putString("PASSWORD", password)
            editor.apply()


            startActivity(Intent(this@LoginActivity,DescriptionActivity::class.java))
        }


    }
}