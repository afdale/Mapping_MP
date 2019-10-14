package com.agneshandayani.mapping_mp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var startButton : ImageButton
    private lateinit var updateButton : ImageButton
    private lateinit var finishButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            startButton = findViewById(R.id.btnStart)
            startButton.setOnClickListener {
                startActivity(Intent(this, FormSubmit::class.java))
            }
            updateButton = findViewById(R.id.btnUpdate)
            updateButton.setOnClickListener {
                startActivity(Intent(this, Adapter::class.java))
            }

            finishButton = findViewById(R.id.btnFinish)
            finishButton.setOnClickListener {
                startActivity(Intent(this, FormFinish::class.java))
            }

        } catch (ex: Exception) {
            Toast.makeText(this, "$ex", Toast.LENGTH_LONG).show()
        }
    }
    }