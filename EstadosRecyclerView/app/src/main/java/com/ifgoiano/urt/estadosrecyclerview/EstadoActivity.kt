package com.ifgoiano.urt.estadosrecyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EstadoActivity : AppCompatActivity() {
    private lateinit var img: ImageView
    private lateinit var tvEstadoName: TextView
    private lateinit var tvEstadoCapital: TextView
    private lateinit var tvEstadoPopulacao: TextView
    private lateinit var tvEstadoRegiao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estado)

        img = findViewById(R.id.img)
        tvEstadoName = findViewById(R.id.tvEstadoName)
        tvEstadoCapital = findViewById(R.id.tvEstadoCapital)
        tvEstadoPopulacao = findViewById(R.id.tvEstadoPopulacao)
        tvEstadoRegiao = findViewById(R.id.tvEstadoRegiao)

        val estadoImg = intent.getIntExtra("estadoImg", 0)
        val estadoNome = intent.getStringExtra("estadoNome")
        val estadoCapital = intent.getStringExtra("estadoCapital")
        val estadoPopulacao = intent.getStringExtra("estadoPopulacao")
        val estadoRegiao = intent.getStringExtra("estadoRegiao")

        img.setImageResource(estadoImg)
        tvEstadoName.text = "Estado: " +estadoNome
        tvEstadoCapital.text = "Capital: " +estadoCapital
        tvEstadoPopulacao.text = "População: " + estadoPopulacao
        tvEstadoRegiao.text = "Região: " + estadoRegiao
    }
}