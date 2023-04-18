package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.myapplication.databinding.ActivityDescriptionBinding
import com.google.gson.Gson
import model.Character

class DescriptionActivity : AppCompatActivity() {

private lateinit var binding: ActivityDescriptionBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val spinner: Spinner = binding.spinnerEditora

         ArrayAdapter.createFromResource(
             this,R.array.editoras,
             android.R.layout.simple_spinner_item
         ).also { adapter ->
             adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
             spinner.adapter = adapter

         }

        val heroTypeSpinner: Spinner = binding.spinnerHeroi

        ArrayAdapter.createFromResource(
            this,R.array.arquetipo,
            android.R.layout.simple_spinner_item
        ).also { adapterHero ->
            adapterHero.setDropDownViewResource(android.R.layout.simple_spinner_item)
            heroTypeSpinner.adapter = adapterHero
        }
      //  val nome_heroi = binding.heroName.text.toString()
       // val idade = binding.heroAge.text.toString()
       // val descricao = binding.descriptionOfHero.text.toString()
      //  val link = binding.heroLink.text.toString()
      //  val data = binding.heroDate.text.toString()


        val sharedPrefs = getSharedPreferences("REGISTRO_HEROI", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        val editora = editor.putString("spinnerSelection", binding.spinnerEditora.getSelectedItem().toString())
        val arquetipo = editor.putString("spinnerSelection", binding.spinnerHeroi.getSelectedItem().toString())

        editor.apply()

        binding.saveHeroButton.setOnClickListener {










        }

    }
}