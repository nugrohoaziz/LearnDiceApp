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
            diceRoll1()
        }
    }

    private fun diceRoll1() {
        val dice = Dice(6)
        val dice2 = Dice2(6)
        val diceRolling = dice.roll()
        val diceRolling2 = dice2.roll()
        val diceImage: ImageView = findViewById(R.id.imageview1)
        val diceImage2: ImageView = findViewById(R.id.imageview2)
        val drawableResource = when(diceRolling){
            6 -> R.drawable.dice_6
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            else -> R.drawable.dice_5
        }
        val drawableResource2 = when(diceRolling2){
            6 -> R.drawable.dice_6
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            else -> R.drawable.dice_5
        }
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        if (drawableResource == drawableResource2){
            Toast.makeText(this,"yeah you win", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "please try again", Toast.LENGTH_SHORT).show()
        }
        diceImage.contentDescription = diceRolling.toString()
    }

    class Dice(var numSide: Int){
        fun roll (): Int{
            return (1..numSide).random()
        }
    }
    class Dice2(var numSide: Int){
        fun roll (): Int{
            return (1..numSide).random()
        }
    }

}


