package com.example.generics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable

class GenericAPIOperationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic_apioperations)
    }

    override fun onStart() {
        super.onStart()

        val observable = Observable.just("Alpha", "Beta", "Gamma", "Delta")
        observable.subscribe() {string -> println("Returned: $string")}

        val personObservable = Observable.just(Mark(), Alan())
        personObservable.subscribe() {person -> println("Returned: $person")}

    }
    open class Person
    class Mark: Person()
    class Alan: Person()

    class NetworkAPI{
        companion object{
            fun getListOfPeople(): Observable<List<Person>>{
                return Observable.just(listOf(Mark(), Alan()))
            }
        }
    }
}
