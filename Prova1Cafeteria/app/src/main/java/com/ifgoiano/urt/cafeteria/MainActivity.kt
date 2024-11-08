package com.ifgoiano.urt.cafeteria

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifgoiano.urt.cafeteria.adapter.CategoryAdapter
import com.ifgoiano.urt.cafeteria.databinding.ActivityMainBinding
import com.ifgoiano.urt.cafeteria.model.Category
import com.ifgoiano.urt.cafeteria.model.CategoryData

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CategoryAdapter
    private var categories: List<Category> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvCatalog.layoutManager = LinearLayoutManager(this)
        binding.rvCatalog.setHasFixedSize(true)

        categories = CategoryData.getCategory()

        adapter = CategoryAdapter(this, categories, onClickCategory())

        binding.rvCatalog.adapter = adapter;
    }

    private fun onClickCategory(): CategoryAdapter.CategoryOnClickListener {
         return object : CategoryAdapter.CategoryOnClickListener {
             @SuppressLint("RestrictedAPI")
             override fun onClickCategory(holder: CategoryAdapter.CategoryViewHolder?, idx: Int) {
                 Log.println(Log.ERROR, "=============", "++++++++++++++++++++++++++++++++++++++++++++++")
                 val category = categories.getOrNull(idx) ?: return

                 if(category == categories[0]){
                     val intent = Intent(baseContext, DrinkSelectorActivity::class.java)
                     startActivity(intent)
                 }else if(category == categories[1]) {
                     binding.tvMsg.text = "Ainda não servimos comida"
                 }else if(category == categories[2]) {
                     binding.tvMsg.text = "Ainda não trabalhamos com mercearia"
                 }

             }

         }
    }
}