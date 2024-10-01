package com.ifgoiano.urt.cronometro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CronometroActivity : AppCompatActivity() {
    lateinit var clockTextView: TextView
    lateinit var startButton: Button
    lateinit var stopButton: Button
    lateinit var resetButton: Button
    lateinit var timerButton: Button

    private var handler: Handler = Handler(Looper.getMainLooper())
    private var startTime: Long = 0L
    private var timeInMilliseconds: Long = 0L
    private var timeSwapBuff: Long = 0L
    private var updatedTime: Long = 0L
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate chamado")

        enableEdgeToEdge()
        setContentView(R.layout.activity_cronometro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState != null) {
            Log.d("MainActivity", "Restaurando estado da atividade")
            startTime = savedInstanceState.getLong("startTime")
            timeInMilliseconds =  savedInstanceState.getLong("timeInMilliseconds")
            running = savedInstanceState.getBoolean("executionState")
        }

        clockTextView = findViewById(R.id.clockTextView)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        resetButton = findViewById(R.id.resetButton)
        timerButton = findViewById(R.id.timerButton)

        startButton.setOnClickListener {
            onClickStart()
        }

        stopButton.setOnClickListener {
            onClickStop()
        }

        resetButton.setOnClickListener {
            onClickReset()
        }

        timerButton.setOnClickListener{
            val intent = Intent(this, TeporizadorActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume chamado")
        if (running){
            handler.postDelayed(runTimer, 0)
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime
            updatedTime = timeSwapBuff + timeInMilliseconds
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop chamado")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("startTime", startTime)
        outState.putLong("timeInMilliseconds", timeInMilliseconds)
        outState.putBoolean("executionState", running)

        Log.d("MainActivity", "onSaveInstanceState chamado")

        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy chamado")
    }

    private fun onClickStart() {
        if (!running) {
            Log.d("MainActivity", "Cronômetro iniciado")
            startTime = SystemClock.uptimeMillis()
            handler.postDelayed(runTimer, 0)
            running = true
        }
    }

    private fun onClickStop() {
        if (running) {
            Log.d("MainActivity", "Cronômetro parado")
            timeSwapBuff += timeInMilliseconds
            handler.removeCallbacks(runTimer)
            running = false
        }
    }

    private fun onClickReset() {
        Log.d("MainActivity", "Cronômetro reiniciado")
        handler.removeCallbacks(runTimer)
        running = false
        startTime = 0L
        timeInMilliseconds = 0L
        timeSwapBuff = 0L
        updatedTime = 0L
        clockTextView.text = "00:00:00"
    }

    private val runTimer = object : Runnable {
        override fun run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime
            updatedTime = timeSwapBuff + timeInMilliseconds

            val secs = (updatedTime / 1000).toInt()
            val hours = secs / 3600
            val minutes = (secs % 3600) / 60
            val seconds = secs % 60

            clockTextView.text = String.format("0%d:%02d:%02d", hours, minutes, seconds)

            handler.postDelayed(this, 1000)
        }
    }
}