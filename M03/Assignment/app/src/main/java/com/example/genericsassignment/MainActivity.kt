package com.example.genericsassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

//    TASK ONE:
    //var mutableList = mutableListOf<String>()
    //mutableList.add(1)

//    TASK TWO:
    //class MyIntegers(int: Int) {
    //    val int: Int = int
    //}
    //var ints = MyIntegers("")


//    TASK THREE:
    fun <T>specificType(t: T, t2: T){ val type: T = t}
    val number = specificType("", 6)

//    TASK FOUR:
    companion object{
        fun <A> getString(a: A): String{
            return "$a"
        }
    }
    class Retrieve{ var num5 = getString(4) }

//    TASK FIVE:
    class GenericConstraints<A>{
        var variable: A? = null
        fun put(a: A){
            variable = a
        }
    }
    val Phone = GenericConstraints<CellularService>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
