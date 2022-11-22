package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<Button>(R.id.button2).setOnClickListener{
            val i = Intent(this@MainActivity2, MainActivity3::class.java)
            i.putExtra("Player1name", findViewById<EditText>(R.id.editTextTextPersonName).text.toString())
            i.putExtra("Player2name", findViewById<EditText>(R.id.editTextTextPersonName2).text.toString())
            startActivity(i)
        }
    }
}