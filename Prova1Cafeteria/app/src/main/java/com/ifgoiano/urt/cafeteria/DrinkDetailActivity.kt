package com.ifgoiano.urt.cafeteria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ifgoiano.urt.cafeteria.databinding.ActivityDrinkDetailBinding

class DrinkDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDrinkDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrinkDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drinkName = intent.getStringExtra("name")
        val drinkDesc = intent.getStringExtra("desc")
        val drinkImg = intent.getIntExtra("img",0)

        binding.tvName.text = drinkName
        binding.tvDesc.text = drinkDesc
        binding.imageView.setImageResource(drinkImg)
    }
}