package com.example.myapplication

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


    }
}