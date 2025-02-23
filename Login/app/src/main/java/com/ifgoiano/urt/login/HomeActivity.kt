package com.ifgoiano.urt.login

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)

        val bundle = intent.extras

        // Receber o nome do usuário passado como parâmetro
        val username = bundle?.getString("username")

        // Exibir a mensagem de boas-vindas
        welcomeTextView.text = "Bem-vindo, $username!"
    }
}