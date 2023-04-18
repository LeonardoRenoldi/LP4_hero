package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val botao_login = binding.loginButton







        botao_login.setOnClickListener{
            startActivity(Intent(this@LoginActivity,DescriptionActivity::class.java))
        }

        binding.cadastroButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity,CadastroActivity::class.java))
        }


    }
}