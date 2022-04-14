package com.example.dicerole

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRoll: Button = findViewById(R.id.buttonRoll)
        buttonRoll.setOnClickListener {
            diceRoll()
        }
    }


    private fun diceRoll() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 6
        val diceImage: ImageView = findViewById(R.id.imageview1)
        val drawableResource = when(diceRoll){
            luckyNumber -> R.drawable.dice_6
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            else -> R.drawable.dice_5
        }
        if (diceRoll == luckyNumber){
             Toast.makeText(this, "yeah you win", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "try again roll dice!", Toast.LENGTH_SHORT).show()
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }

    class Dice(var numSide: Int){
        fun roll (): Int{
            return (1..numSide).random()
        }
    }

}


