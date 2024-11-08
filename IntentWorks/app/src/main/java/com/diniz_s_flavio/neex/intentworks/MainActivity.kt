package com.diniz_s_flavio.neex.intentworks

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.diniz_s_flavio.neex.intentworks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener{
            val login = binding.edLogin.text.toString()
            val senha = binding.edSenha.text.toString()

            if(login == "flavio" && senha == "123"){
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("login", binding.edLogin.text.toString())

                startActivity(intent)
            }else{
                binding.tvErrorMsg.text = "Login ou senha incorretos"
            }
        }
    }
}