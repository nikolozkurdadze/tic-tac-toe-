package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var Score1 = 0;
        var Score2 = 0;

        var score = findViewById<TextView>(R.id.score)
        var scorel = findViewById<TextView>(R.id.score2)
        var whichplayer = findViewById<TextView>(R.id.whichplayer)
        var restart = findViewById<Button>(R.id.restart)
        var Buttons = arrayOf<Button>(
            findViewById<Button>(R.id.B1),
            findViewById<Button>(R.id.B2),
            findViewById<Button>(R.id.B3),
            findViewById<Button>(R.id.B4),
            findViewById<Button>(R.id.B5),
            findViewById<Button>(R.id.B6),
            findViewById<Button>(R.id.B7),
            findViewById<Button>(R.id.B8),
            findViewById<Button>(R.id.B9)
        );
        var OX = arrayOf<Int>(
            0,0,0,0,0,0,0,0,0
        )

        var CurrentTurn = 1

        restart.setOnClickListener{
            Score1=0
            Score2=0
            println("Resetting...")
            val i = Intent(this@MainActivity3, MainActivity2::class.java)
            startActivity(i)
        }

        for(ID in Buttons.indices){
            Buttons[ID].setOnClickListener{
                if(OX[ID]==0) {
                    OX[ID] = CurrentTurn
                    if(CurrentTurn == 1) Buttons[ID].text = "X";
                    else Buttons[ID].text = "O"
                    var tempCheck = true;
                    for (A in OX.indices) {
                        if (OX[A] == 0) tempCheck = false
                    }
                    if (tempCheck){
                        for (A in OX.indices) {
                            OX[A] = 0
                            Buttons[A].text = ""
                        }
                    }
                    if (checkForEndOX(OX, 1) == 1) {
                        Score1++
                        for (A in OX.indices) {
                            OX[A] = 0
                            Buttons[A].text = ""
                        }
                    } else if (checkForEndOX(OX, 2) == 2) {
                        Score2++
                        for (A in OX.indices) {
                            OX[A] = 0
                            Buttons[A].text = ""
                        }
                    }
                    if (CurrentTurn == 1) CurrentTurn = 2
                    else CurrentTurn = 1
                    score.text = getIntent().getStringExtra("Player1name") + ": " + Score1
                    scorel.text = getIntent().getStringExtra("Player2name") + ": " + Score2
                    whichplayer.text = "Player "+CurrentTurn+"'s turn";
                }
            }
        }
    }

    fun checkForEndOX(OX:Array<Int>, A:Int): Int{
        if(OX[0]==A){
            if (OX[1]==A && OX[2] == A)
                return A
            else if (OX[3]==A && OX[6] == A)
                return A
            else if (OX[4]==A && OX[8] == A)
                return A
        }
        if (OX[1]==A){
            if (OX[4]==A && OX[7] == A)
                return A
        }
        if (OX[2]==A){
            if (OX[5]==A && OX[8] == A)
                return A
        }
        if (OX[3]==1){
            if (OX[4]==A && OX[5] == A)
                return A
        }
        if (OX[4]==A){
            if (OX[6]==A && OX[2] == A)
                return A
        }
        if (OX[6]==A){
            if (OX[7]==A && OX[8] == A)
                return A
        }
        return 0
    }
}