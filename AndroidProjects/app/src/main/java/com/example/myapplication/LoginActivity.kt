package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import api.endPoint
import com.example.myapplication.databinding.ActivityLoginBinding
import model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utils.NetworkUtils

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val email = binding.emailInput.text.toString()
        val password = binding.passwordInput.text.toString()
        val botao_login = binding.loginButton




       fun login(){
       val retrofitClient = NetworkUtils.getRetrofitInstance("https://fundatec.herokuapp.com/user")
           val endpoint = retrofitClient.create(endPoint::class.java)

           val callback = endpoint.autenticacao(email, password)

           callback.enqueue(object : Callback<User>{
               override fun onResponse(call: Call<User>, response: Response<User>) {
                   Toast.makeText(baseContext, "Name: ${response.body()?.email}", Toast.LENGTH_LONG).show();
                   Toast.makeText(baseContext, "Name: ${response.body()?.password}", Toast.LENGTH_LONG).show()
               }

               override fun onFailure(call: Call<User>, t: Throwable) {
                   println("Erro ao realizar o login")
               }
           })
       }


        binding.loginButton.setOnClickListener{
            startActivity(Intent(this@LoginActivity,DescriptionActivity::class.java))
        }

        binding.cadastroButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity,CadastroActivity::class.java))
        }


    }
}