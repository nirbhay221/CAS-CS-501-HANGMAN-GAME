package com.example.hangmangame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var playButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playButton = findViewById(R.id.playId);
        playButton.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
            Toast.makeText(this,"Welcome To Hangman!",Toast.LENGTH_LONG).show()
        }

    }
}