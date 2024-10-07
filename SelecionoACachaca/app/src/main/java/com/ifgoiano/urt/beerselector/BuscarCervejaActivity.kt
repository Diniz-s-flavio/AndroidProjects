package com.ifgoiano.urt.beerselector

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BuscarCervejaActivity : AppCompatActivity() {
    private lateinit var spinnerCerveja: Spinner
    private lateinit var buttonBuscar: Button
    private lateinit var textViewMarcas: TextView
    private val expertCerveja = ExpertCerveja()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_linear)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerCerveja = findViewById(R.id.spinnerCerveja)
        buttonBuscar = findViewById(R.id.buttonBuscar)
        textViewMarcas = findViewById(R.id.textViewMarcas)

        val tiposCerveja = listOf("Pilsen", "IPA", "Stout", "Lager", "Weiss")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposCerveja)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCerveja.adapter = adapter

        buttonBuscar.setOnClickListener {
            val tipoSelecionado = spinnerCerveja.selectedItem.toString()
            val marcas = expertCerveja.getMarcas(tipoSelecionado)
            textViewMarcas.text = marcas.joinToString("\n")
        }
    }
}