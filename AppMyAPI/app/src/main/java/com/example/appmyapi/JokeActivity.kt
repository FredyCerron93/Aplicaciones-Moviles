package com.example.appmyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_joke.*

class JokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        btnBroma.setOnClickListener{
            loadJoke()
        }
    }

    private fun loadJoke() {
        tvBroma.text = "Jalar la broma del API!!!"
    }
}
