package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCadastroBinding


class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailRegister = binding.registerEmail.text.toString()
        val passwordRegister = binding.registerPassword.text.toString()
        val registerBotao = binding.registerButton


        binding.registerButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("REGISTRO", MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("EMAIL", emailRegister)
            editor.putString("PASSWORD", passwordRegister)
            editor.apply()

            startActivity(Intent(this@CadastroActivity,LoginActivity::class.java))
        }

    }
}