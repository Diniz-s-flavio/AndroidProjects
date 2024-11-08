package com.ifgoiano.urt.cafeteria

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifgoiano.urt.cafeteria.adapter.DrinkAdapter
import com.ifgoiano.urt.cafeteria.databinding.ActivityDrinkSelectorBinding
import com.ifgoiano.urt.cafeteria.model.Drink
import com.ifgoiano.urt.cafeteria.model.DrinkData

class DrinkSelectorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDrinkSelectorBinding
    lateinit var adapter: DrinkAdapter
    private var drinks: List<Drink> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDrinkSelectorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvDrinkSelector.layoutManager = LinearLayoutManager(this)
        binding.rvDrinkSelector.setHasFixedSize(true)

        drinks = DrinkData.getDrinkList()

        adapter = DrinkAdapter(this, drinks, onClickDrink())

        binding.rvDrinkSelector.adapter = adapter;
    }

    private fun onClickDrink(): DrinkAdapter.DrinkOnClickListener {
        return object : DrinkAdapter.DrinkOnClickListener {
            @SuppressLint("RestrictedAPI")
            override fun onClickDrink(holder: DrinkAdapter.DrinkViewHolder?, idx: Int) {
                val drink = drinks.getOrNull(idx) ?: return

                val intent = Intent(baseContext, DrinkDetailActivity::class.java)
                intent.putExtra("name", drink.name)
                intent.putExtra("desc",drink.descricao)
                intent.putExtra("img", drink.img)
                startActivity(intent)
            }

        }
    }
}