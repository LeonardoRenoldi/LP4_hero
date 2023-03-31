package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val email = binding.emailInput.text.toString()
        val password = binding.passwordInput.text.toString()
        val botao_login = binding.loginButton




        botao_login.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                email.trim()
                password.trim()
                botao_login.isEnabled = true
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })


        binding.loginButton.setOnClickListener{



            val sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("EMAIL", email)
            editor.putString("PASSWORD", password)
            editor.apply()


            startActivity(Intent(this@LoginActivity,DescriptionActivity::class.java))
        }


    }
}