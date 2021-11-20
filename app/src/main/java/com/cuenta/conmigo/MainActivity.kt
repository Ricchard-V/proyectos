package com.cuenta.conmigo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nav(view: android.view.View) {
        val miIntent:Intent = Intent(this, HomeActivity2::class.java)
        startActivity(miIntent)
    }
}