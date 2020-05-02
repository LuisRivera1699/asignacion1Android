package com.example.asignacion1

import kotlin.random.Random

class Randomizer {

    // Array shuffle function
    private fun shuffle(intarr : IntArray) : IntArray{

        var arraux : IntArray = intarr.copyOf()
        var rnd = Random(123)

        for ( i in arraux.size-1 downTo 1){
            val j = rnd.nextInt(i+1)
            val temp = arraux[i]
            arraux[i] = arraux[j]
            arraux[j] = temp
        }
        return arraux
    }

    // Shuffle and get the first q numbers of the given array
    private fun shuffleAndGetFirstQNumbers(intarr : IntArray, q : Int) : IntArray{
        var shuffled : IntArray = shuffle(intarr)
        var returnedArray = IntArray(0)

        for (i in 0 until q){
            returnedArray = returnedArray.plus(shuffled[i])
        }

        return returnedArray

    }

    // Make array of couples and return it shuffled
    fun makeArrayOfCouples(intarr : IntArray, q: Int) : IntArray {
        var auxarr = shuffleAndGetFirstQNumbers(intarr, q)
        var couplesArray = auxarr.plus(auxarr)
        return shuffle(couplesArray)
    }

}