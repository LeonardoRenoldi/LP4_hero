package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.myapplication.databinding.ActivityDescriptionBinding

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



        binding.saveHeroButton.setOnClickListener {

            val nome_heroi = binding.heroName.toString()
            val idade = binding.heroAge.toString()
            val descricao = binding.descriptionOfHero.toString()

            val sharedPrefs = getSharedPreferences("REGISTRO_HEROI", Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()

            editor.putString("NOME_HEROI", nome_heroi)
            editor.putString("DESCRICÃO", descricao)
            editor.putString("IDADE", idade)

            editor.putInt("spinnerSelection", binding.spinnerEditora.selectedItemPosition)
            editor.putInt("spinnerSelection", binding.spinnerHeroi.selectedItemPosition)
            editor.apply()
        }

    }
}