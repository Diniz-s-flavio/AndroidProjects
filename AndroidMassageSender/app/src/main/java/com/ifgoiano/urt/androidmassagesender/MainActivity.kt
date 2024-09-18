package com.ifgoiano.urt.androidmassagesender

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btnSendMsg : Button
    lateinit var editTextSendMsg: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnSendMsg =  findViewById(R.id.btnSendMsg)
        editTextSendMsg =  findViewById(R.id.editTextMsg)

        btnSendMsg.setOnClickListener {
            val message = editTextSendMsg.text.toString()

            // Iniciar a nova atividade e enviar o texto
            val intent = Intent(this, MessageRenderActivity::class.java)
            intent.putExtra("msg", message)
            startActivity(intent)
        }
    }
}