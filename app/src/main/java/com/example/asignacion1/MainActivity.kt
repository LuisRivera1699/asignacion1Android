package com.example.asignacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    // Array of emojis unicodes
    var intarr : IntArray? = null

    // Layout views
    var buttons : Array<Button>? = null
    var teVi : TextView? = null

    // Int array for storing buttons.size/2 numbers of shuffled emojis
    var couplesArray : IntArray? = null

    // Current couples
    var firstCoupleElement : Button? = null
    var secondCoupleElement : Button? = null

    // Game process variables
    var attempts : Int = 0
    var goodMoves : Int = 0
    var won : Boolean = false

    // Random for shuffling and generating random emojis array
    val rnd = Randomizer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get text view from layout and set text to "Turno Jugador"
        teVi = findViewById(R.id.tevi1)
        teVi!!.text = "Turno Jugador"

        // Fill intarr with emojis unicode values
        intarr = intArrayOf(
            0x1F60A,
            0x1F4A9,
            0x1F921,
            0x1F479,
            0x1F47B,
            0x1F47D,
            0x1F47E,
            0x1F916,
            0x1F64A,
            0x1F4A5,
            0x1F573,
            0x1F4A3,
            0x1F4AC,
            0x1F4AA,
            0x1F385,
            0x1F9DC,
            0x1F9DE,
            0x1F9DF,
            0x1F3C3,
            0x1F483,
            0x1F93A
        )

        // fill buttons array with buttons from the layout
        buttons = arrayOf(
            findViewById(R.id.but1),
            findViewById(R.id.but2),
            findViewById(R.id.but3),
            findViewById(R.id.but4),
            findViewById(R.id.but5),
            findViewById(R.id.but6),
            findViewById(R.id.but7),
            findViewById(R.id.but8),
            findViewById(R.id.but9),
            findViewById(R.id.but10),
            findViewById(R.id.but11),
            findViewById(R.id.but12)
        )

        // Make a emoji couples array with shuffled emojis from the emojis unicode values array
        couplesArray = rnd.makeArrayOfCouples(intarr!!, buttons!!.size/2)

        //Log.i("Asignacion 1", "true")

        // Initializate buttons behaviour
        for (i in buttons!!){
            // Characteristics
            i.isClickable = true
            i.textSize = 40.03F

            // OnClickListener with condition
            i.setOnClickListener {
                // If hasn't won yet, when clicked, it text will be placed with emoji
                if (!won){
                    // Get button index
                    val buttonIndex = buttons!!.indexOf(i)
                    // Set button text to emoji by processing the unicode value
                    i.text = String(Character.toChars(couplesArray!![buttonIndex]))
                    // Set the current couple element
                    setCurrentCoupleElement(i)
                }
                // If won, when clicked, the activity will be recreated
                else{
                    // Reload app
                    this.recreate()
                }
            }
        }

    }

    fun setCurrentCoupleElement(clickedButton : Button){
        // If the first couple element is null, it will be filled with the button clicked
        if (firstCoupleElement == null){
            firstCoupleElement = clickedButton
        }
        // Otherwise, the secondCoupleElement will be filled and checked if the two elements match
        else{
            secondCoupleElement = clickedButton
            // Check for match
            checkForMatch()
        }

    }

    fun checkForMatch(){

        // If they match
        if (firstCoupleElement!!.text == secondCoupleElement!!.text){
            // Number of attempts and goodMoves will be incremented in one
            attempts += 1
            goodMoves += 1
            // TextView text set to  "Turno Jugador"
            teVi!!.text = "Turno Jugador"

            // Current couple elements won't be clickable anymore
            firstCoupleElement!!.isClickable = false
            secondCoupleElement!!. isClickable = false

            // Current couple elements set back to null
            firstCoupleElement = null
            secondCoupleElement = null

            // Check for win
            checkForWin()

        }
        // Otherwise
        else {
            // Current couple elements text will be set back to ""
            firstCoupleElement!!.text = ""
            secondCoupleElement!!.text = ""

            // Current couple elements set back to null
            firstCoupleElement = null
            secondCoupleElement = null

            // Number of attempts incremented by 1
            attempts += 1

            // Text View set to "Error"
            teVi!!.text = "Error"
        }
        //Log.i("Asignacion 1", attempts.toString())
    }

    // Check for win
    fun checkForWin(){
        // If the good moves reaches to buttons array size divided by 2
        if (goodMoves == buttons!!.size/2){
            // won variable will be set to true
            won = true

            // Text View will be set to "Fin, lo terminaste en x intentos"
            teVi!!.text = "Fin, lo terminaste en ${attempts.toString()} intentos"

            // Buttons will be clickable again, as the game is won, it will be able to reload when clicked
            for (i in buttons!!){
                i.isClickable = true
            }

        }
        // Otherwise it wont do nothing
        else{
            // If only it was a "pass" like in python or java.
        }
    }

}
