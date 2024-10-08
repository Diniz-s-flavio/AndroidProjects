package com.ifgoiano.urt.pesquisaeleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val btnSubmeter = findViewById<Button>(R.id.btnSubmeter)

        // Spinner para Estado
        val spinnerEstado = findViewById<Spinner>(R.id.spinnerEstado)
        ArrayAdapter.createFromResource(
            this, R.array.estados_brasil, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerEstado.adapter = adapter
        }

        // Spinner para Vereador
        val spinnerVereador = findViewById<Spinner>(R.id.spinnerVereador)
        ArrayAdapter.createFromResource(
            this, R.array.vereadores, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerVereador.adapter = adapter
        }

        // Configura o clique no botão de submeter
        btnSubmeter.setOnClickListener {
            val nome = findViewById<EditText>(R.id.etNome).text.toString()
            val titulo = findViewById<EditText>(R.id.etTitulo).text.toString()
            val zona = findViewById<EditText>(R.id.etZona).text.toString()
            val secao = findViewById<EditText>(R.id.etSecao).text.toString()
            val cidade = findViewById<EditText>(R.id.etCidade).text.toString()
            val estado = spinnerEstado.selectedItem.toString()

            // Pegando a escolha do prefeito
            val rgPrefeito = findViewById<RadioGroup>(R.id.rgPrefeito)
            val prefeitoId = rgPrefeito.checkedRadioButtonId
            val prefeitoEscolhido = findViewById<RadioButton>(prefeitoId).text.toString()

            // Pegando a escolha do vereador
            val vereadorEscolhido = spinnerVereador.selectedItem.toString()

            // Pegando os partidos preferidos
            val partidos = mutableListOf<String>()
            if (findViewById<CheckBox>(R.id.partido1).isChecked) partidos.add("PMD")
            if (findViewById<CheckBox>(R.id.partido2).isChecked) partidos.add("PT")
            if (findViewById<CheckBox>(R.id.partido1).isChecked) partidos.add("PSOL")
            if (findViewById<CheckBox>(R.id.partido2).isChecked) partidos.add("PMDB")
            if (findViewById<CheckBox>(R.id.partido1).isChecked) partidos.add("PTB")
            if (findViewById<CheckBox>(R.id.partido2).isChecked) partidos.add("PSDB")
            // Continue para os outros partidos

            // Passando os dados para a próxima activity
            val intent = Intent(this, ResumoActivity::class.java)
            intent.putExtra("NOME", nome)
            intent.putExtra("TITULO", titulo)
            intent.putExtra("ZONA", zona)
            intent.putExtra("SECAO", secao)
            intent.putExtra("CIDADE", cidade)
            intent.putExtra("ESTADO", estado)
            intent.putExtra("PREFEITO", prefeitoEscolhido)
            intent.putExtra("VEREADOR", vereadorEscolhido)
            intent.putStringArrayListExtra("PARTIDOS", ArrayList(partidos))
            startActivity(intent)
        }
    }
}