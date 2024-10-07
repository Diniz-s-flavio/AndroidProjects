package com.ifgoiano.urt.cronometro

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TeporizadorActivity : AppCompatActivity() {
    lateinit var hoursInput: EditText
    lateinit var minutesInput: EditText
    lateinit var secondsInput: EditText
    lateinit var timerTextView: TextView
    lateinit var startButton: Button
    lateinit var stopButton: Button
    lateinit var resetButton: Button
    lateinit var restartButton: Button
    lateinit var stopwatchButton: Button

    private var handler: Handler = Handler(Looper.getMainLooper())
    private var startTime: Long = 0L
    private var timeLeftInMillis: Long = 0L
    private var initialTimeInMillis: Long = 0L // Tempo original definido pelo usuário
    private var running = false

    private val countdownTimer = object : Runnable {
        override fun run() {
            if (timeLeftInMillis > 0) {
                timeLeftInMillis -= 1000
                updateTimerDisplay()
                handler.postDelayed(this, 1000)
            } else {
                running = false
                Toast.makeText(this@TeporizadorActivity, "Tempo finalizado!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teporizador)


        if (savedInstanceState != null) {
            timeLeftInMillis = savedInstanceState.getLong("timeLeftInMillis")
            initialTimeInMillis = savedInstanceState.getLong("initialTimeInMillis")
            running = savedInstanceState.getBoolean("running")

            if (running) {
                handler.postDelayed(countdownTimer, 0)
            } else {
                updateTimerDisplay()
            }
        }

        hoursInput = findViewById(R.id.hoursInput)
        minutesInput = findViewById(R.id.minutesInput)
        secondsInput = findViewById(R.id.secondsInput)
        timerTextView = findViewById(R.id.timerTextView)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        resetButton = findViewById(R.id.resetButton)
        restartButton = findViewById(R.id.restartButton)
        stopwatchButton = findViewById(R.id.stopwatchButton)

        startButton.setOnClickListener {
            if (!running) {
                if (initialTimeInMillis == 0L) {
                    val hours = hoursInput.text.toString().toIntOrNull() ?: 0
                    val minutes = minutesInput.text.toString().toIntOrNull() ?: 0
                    val seconds = secondsInput.text.toString().toIntOrNull() ?: 0

                    initialTimeInMillis = (hours * 3600 + minutes * 60 + seconds) * 1000L
                    timeLeftInMillis = initialTimeInMillis

                    if (timeLeftInMillis <= 0) {
                        Toast.makeText(this, "Por favor, insira um tempo válido!", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }

                running = true
                handler.postDelayed(countdownTimer, 0)
            }
        }

        // Parar o temporizador
        stopButton.setOnClickListener {
            if (running) {
                handler.removeCallbacks(countdownTimer)
                running = false
            }
        }

        resetButton.setOnClickListener {
            handler.removeCallbacks(countdownTimer)
            running = false
            timeLeftInMillis = 0L
            initialTimeInMillis = 0L
            timerTextView.text = "00:00:00"
            hoursInput.setText("")
            minutesInput.setText("")
            secondsInput.setText("")
        }
        restartButton.setOnClickListener {
            handler.removeCallbacks(countdownTimer)
            running = false
            timeLeftInMillis = initialTimeInMillis
            updateTimerDisplay()
        }

        stopwatchButton.setOnClickListener{
            val intent = Intent(this, CronometroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("timeLeftInMillis", timeLeftInMillis)
        outState.putLong("initialTimeInMillis", initialTimeInMillis)
        outState.putBoolean("running", running)

        super.onSaveInstanceState(outState)
    }

    private fun updateTimerDisplay() {
        val secs = (timeLeftInMillis / 1000).toInt()
        val hours = secs / 3600
        val minutes = (secs % 3600) / 60
        val seconds = secs % 60

        timerTextView.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}