package com.ifgoiano.urt.cronometro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var clockTextView: TextView
    lateinit var startButton: Button
    lateinit var stopButton: Button
    lateinit var resetButton: Button

    private var handler: Handler = Handler(Looper.getMainLooper())
    private var startTime: Long = 0L
    private var timeInMilliseconds: Long = 0L
    private var timeSwapBuff: Long = 0L
    private var updatedTime: Long = 0L
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        clockTextView = findViewById(R.id.clockTextView)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        resetButton = findViewById(R.id.resetButton)

        startButton.setOnClickListener {
            onClickStart()
        }

        stopButton.setOnClickListener {
            onClickStop()
        }

        resetButton.setOnClickListener {
            onClickReset()
        }
    }

    private fun onClickStart() {
        if (!running) {
            startTime = SystemClock.uptimeMillis()
            handler.postDelayed(runTimer, 0)
            running = true
        }
    }

    private fun onClickStop() {
        if (running) {
            timeSwapBuff += timeInMilliseconds
            handler.removeCallbacks(runTimer)
            running = false
        }
    }

    private fun onClickReset() {
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