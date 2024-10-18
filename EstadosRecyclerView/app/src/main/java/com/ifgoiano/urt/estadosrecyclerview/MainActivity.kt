package com.ifgoiano.urt.estadosrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var estados: List<Estado>? = emptyList()
    private lateinit var adapter: EstadoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

        estados = EstadoData.getEstados()

        adapter = EstadoAdapter(this, estados, onClickEstado())
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun onClickEstado(): EstadoAdapter.EstadoOnCLickListener {
        return object : EstadoAdapter.EstadoOnCLickListener {
            @SuppressLint("RestrictedApi")
            override fun onClickEstado(holder: EstadoAdapter.EstadosViewHolder?, idx: Int)

            {
                val estado = estados?.getOrNull(idx) ?: return
                val intent = Intent(baseContext, EstadoActivity::class.java)
                val img: ImageView = holder!!.img
                intent.putExtra("estadoImg", estado.img)
                intent.putExtra("estadoNome", estado.nome)
                intent.putExtra("estadoCapital", estado.capital)
                intent.putExtra("estadoPopulacao", estado.populacao)
                intent.putExtra("estadoRegiao", estado.regiao)
                startActivity(intent)
            }
        }
    }
}