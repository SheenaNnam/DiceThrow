package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {
    private val currRoll = MutableLiveData<Int>() //textView to die
    var dieSides: Int = 6

    fun rollDie(dieSelection : Int = 6){
        currRoll.value =  (Random.nextInt(1, dieSelection+1))
    }

    fun getDieRoll() : LiveData<Int> {
        return currRoll
    }

    fun setSides(sides:Int){
        dieSides = sides
    }

}