package com.example.hangmangame

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var playButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_landscape)
        } else {
            setContentView(R.layout.activity_main)
        }
        playButton = findViewById(R.id.playId);
        playButton.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
            Toast.makeText(this,"Welcome To Hangman!",Toast.LENGTH_LONG).show()
        }

    }
}