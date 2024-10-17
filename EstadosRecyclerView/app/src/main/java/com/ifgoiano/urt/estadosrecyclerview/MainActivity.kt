package com.ifgoiano.urt.estadosrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var estados: List<Estado>? = emptyList()
    private lateinit var adapter: EstadoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
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

    private fun onClickEstado(): EstadoAdapter.EstadoOnCLickListener {
        return object : EstadoAdapter.EstadoOnCLickListener {
            override fun onClickEstado(holder: EstadoAdapter.EstadosViewHolder?, idx: Int)

            {
                //Se planetas for null, o Elvis operator ?: substitui planetas por uma lista vazia (emptyList()).
                //Se a lista não for null, ele acessa o item na posição idx normalmente.
                val estado = (estados ?: emptyList())[idx]
                Toast.makeText(this@MainActivity, "Estado: ${estado.nome}", Toast.LENGTH_LONG).show()
            }
        }
    }
}