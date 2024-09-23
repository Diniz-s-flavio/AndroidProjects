package com.ifgoiano.urt.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var usernameTextField: EditText
    lateinit var passwordTextField: EditText
    lateinit var submitLoginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameTextField =  findViewById(R.id.usernameTextField)
        passwordTextField = findViewById(R.id.passwordTextField)
        submitLoginButton = findViewById(R.id.submitLoginButton)

        submitLoginButton.setOnClickListener {
            val username = usernameTextField.text.toString()
            val password = passwordTextField.text.toString()

            if (username == "flavio" && password == "123") {
                // Login correto, ir para a segunda atividade
                val intent = Intent(this, HomeActivity::class.java)
                val bundle = Bundle()
                bundle.putString("username", username)

                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                // Informar ao usuário que as credenciais estão incorretas
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()

                // Limpar os campos de texto
                usernameTextField.text.clear()
                passwordTextField.text.clear()
            }
        }
    }
}