package com.example.generics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfStrings = mutableListOf<String>("d", "c", "b", "a")
        listOfStrings.add("-a")

        fun <A> getString(a: A): String{
            return "$a"
        }
        getString(3)

        /*
        class Box<T>{
            private var contents: T? = null
            fun put(t: T){
                contents = t
            }

            fun get(): T? {
                return contents
            }
        }

        val stringBox = Box<String>()
        stringBox.put("a string")
        println(stringBox.get())
        */

    }
}
