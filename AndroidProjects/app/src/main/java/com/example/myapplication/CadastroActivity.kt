package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCadastroBinding
import com.google.gson.Gson
import model.User


class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailRegister = binding.registerEmail.text.toString()
        val passwordRegister = binding.registerPassword.text.toString()
        val nameRegister = binding.userName.text.toString()
        val user = User(emailRegister,passwordRegister,nameRegister)
        val registerBotao = binding.registerButton



        registerBotao.setOnClickListener {
            val sharedPreferences = getSharedPreferences("User_response", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = Gson()
            val saveUser = gson.toJson(user)
            editor.putString("user_response",saveUser)
            editor.apply()

            startActivity(Intent(this@CadastroActivity,LoginActivity::class.java))
        }

    }
}