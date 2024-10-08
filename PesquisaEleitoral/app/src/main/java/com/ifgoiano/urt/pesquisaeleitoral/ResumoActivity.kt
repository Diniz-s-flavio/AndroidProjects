package com.ifgoiano.urt.pesquisaeleitoral

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResumoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo)

        // Recupera os dados da Intent
        val nome = intent.getStringExtra("NOME")
        val titulo = intent.getStringExtra("TITULO")
        val zona = intent.getStringExtra("ZONA")
        val secao = intent.getStringExtra("SECAO")
        val cidade = intent.getStringExtra("CIDADE")
        val estado = intent.getStringExtra("ESTADO")
        val prefeito = intent.getStringExtra("PREFEITO")
        val vereador = intent.getStringExtra("VEREADOR")
        val partidos = intent.getStringArrayListExtra("PARTIDOS")
        println(partidos.toString())

        // Formata e exibe os dados
        val resumoTextView = findViewById<TextView>(R.id.tvResumo)
        resumoTextView.text = """
            Nome: $nome
            Título de Eleitor: $titulo
            Zona: $zona
            Seção: $secao
            Cidade: $cidade
            Estado: $estado
            Prefeito Escolhido: $prefeito
            Vereador Escolhido: $vereador
            Partidos Preferidos: ${partidos?.joinToString(", ")}
        """.trimIndent()
    }
}