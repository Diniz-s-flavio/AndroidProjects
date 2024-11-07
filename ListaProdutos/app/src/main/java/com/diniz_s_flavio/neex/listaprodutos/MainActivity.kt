package com.diniz_s_flavio.neex.listaprodutos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diniz_s_flavio.neex.listaprodutos.adapter.AdapterProduto
import com.diniz_s_flavio.neex.listaprodutos.databinding.ActivityMainBinding
import com.diniz_s_flavio.neex.listaprodutos.model.Produto

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.recyclerViewProdutos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProdutos.setHasFixedSize(true)

        //Cofigurar Adapter

        val listaProdutos: MutableList<Produto> = mutableListOf()

        val adapterProduto = AdapterProduto(this, listaProdutos)
        binding.recyclerViewProdutos.adapter = adapterProduto
    }
}