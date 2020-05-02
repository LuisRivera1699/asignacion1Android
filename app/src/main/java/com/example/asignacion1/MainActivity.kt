package com.example.asignacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val intarr : IntArray = intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12)

    var emojiArray : Array<String>? = null


    var buttons : Array<Button>? = null
    var teVi : TextView? = null

    var couplesArray : IntArray? = null

    var firstCoupleElement : Button? = null
    var secondCoupleElement : Button? = null

    var attempts : Int = 0
    var goodMoves : Int = 0
    var won : Boolean = false

    val rnd = Randomizer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        teVi = findViewById(R.id.tevi1)
        teVi!!.text = "Turno Jugador"

        emojiArray = arrayOf(
            getEmoji(0x1F60A),
            getEmoji(0x1F4A9),
            getEmoji(0x1F921),
            getEmoji(0x1F479),
            getEmoji(0x1F47B),
            getEmoji(0x1F47D),
            getEmoji(0x1F47E),
            getEmoji(0x1F916),
            getEmoji(0x1F64A),
            getEmoji(0x1F4A5),
            getEmoji(0x1F573),
            getEmoji(0x1F4A3),
            getEmoji(0x1F4AC),
            getEmoji(0x1F4AA),
            getEmoji(0x1F385),
            getEmoji(0x1F9DC),
            getEmoji(0x1F9DE),
            getEmoji(0x1F9DF),
            getEmoji(0x1F3C3),
            getEmoji(0x1F483),
            getEmoji(0x1F93A)
        )

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

        couplesArray = rnd.makeArrayOfCouples(intarr, buttons!!.size/2)
        Log.i("Asignacion 1", "true")

        for (i in buttons!!){
            i.isClickable = true
            i.setOnClickListener {
                if (!won){
                    val buttonIndex = buttons!!.indexOf(i)
                    i.text = couplesArray!![buttonIndex].toString()
                    setCurrentCoupleElement(i)
                }else{
                    // Reiniciar app
                    this.recreate()
                }
            }
        }
    }

    fun setCurrentCoupleElement(clickedButton : Button){

        if (firstCoupleElement == null){
            firstCoupleElement = clickedButton
        } else{
            secondCoupleElement = clickedButton
            checkCouple()
        }

    }

    fun checkCouple(){
        if (firstCoupleElement!!.text == secondCoupleElement!!.text){
            attempts += 1

            firstCoupleElement!!.isClickable = false
            secondCoupleElement!!. isClickable = false

            firstCoupleElement = null
            secondCoupleElement = null

            goodMoves += 1
            teVi!!.text = "Turno Jugador"

            checkForWin()
        }else {
            firstCoupleElement!!.text = ""
            secondCoupleElement!!.text = ""

            firstCoupleElement = null
            secondCoupleElement = null

            attempts += 1
            teVi!!.text = "Error"
        }
        Log.i("Asignacion 1", attempts.toString())
    }

    fun checkForWin(){
        if (goodMoves == buttons!!.size/2){
            won = true
            teVi!!.text = "Fin, lo terminaste en ${attempts.toString()} intentos"
            for (i in buttons!!){
                i.isClickable = true
            }
        }else{

        }
    }

    fun getEmoji(unicode: Int): String {
        return String(Character.toChars(unicode))
    }

}
