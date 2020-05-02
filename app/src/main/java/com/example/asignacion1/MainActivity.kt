package com.example.asignacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val intarr : IntArray = intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12)

    var buttons : Array<Button>? = null
    var couplesArray : IntArray? = null

    val rnd = Randomizer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        couplesArray = rnd.makeArrayOfCouples(intarr, buttons!!.size)
        Log.i("Asignacion 1", "true")
    }
}
