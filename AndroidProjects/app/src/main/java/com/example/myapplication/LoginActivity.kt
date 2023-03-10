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

            startActivity(Intent(this@LoginActivity,DescriptionActivity::class.java))
        }

        fun salvarDados(){
            val saveEmail = binding.emailInput.text.toString()

            val sharedPreferences = getSharedPreferences("Email",Context.MODE_PRIVATE)
        }
    }
}