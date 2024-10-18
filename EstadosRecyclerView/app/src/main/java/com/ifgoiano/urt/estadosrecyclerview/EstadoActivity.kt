package com.ifgoiano.urt.estadosrecyclerview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EstadoActivity : AppCompatActivity() {
    lateinit var tvEstadoName: TextView
    lateinit var tvEstadoCapital: TextView
    lateinit var tvEstadoPopulacao: TextView
    lateinit var tvEstadoRegiao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estado)
        
        tvEstadoName = findViewById(R.id.tvEstadoName)
        tvEstadoCapital = findViewById(R.id.tvEstadoCapital)
        tvEstadoPopulacao = findViewById(R.id.tvEstadoPopulacao)
        tvEstadoRegiao = findViewById(R.id.tvEstadoRegiao)
    }
}