package com.example.genericsassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable

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

//    TASK FIVE & ON:
    class CellularService<s: String>{
        var variable: String? = null
        fun put(a: String){
            variable = a
        }
    }
    var tMobile = CellularService<String>()
    var verizon = CellularService<String>()
    class Phone(provider: CellularService<String>, provider2: CellularService<String>)


    override fun onStart() {
        super.onStart()

        val observableInts = Observable.just(5, 23, 67)
        var list = arrayListOf<Int>()
        observableInts.subscribe() {int -> list.add(int)}

        data class Actor(val actor: String)
        val actor1 = Actor("Tom Cruise")
        val actor2 = Actor("Brad Pitt")

        val observableActors = Observable.just(actor1, actor2)
        var actorList = arrayListOf<Actor>()
        observableActors.subscribe() {actor -> actorList.add(actor)}

        data class Movie(val title: String, val mainCharacter: String, val genre: String, val sequels: Boolean)
        val movie1 = Movie("Incredibles", "Bob", "Super Heroes", true)
        val movie2 = Movie("Iron Man", "Tony Stark", "Marvel Super Heroes", true)
        val movie3 = Movie("Inception", "Cobb & Ariadne", "Sci-Fi", false)
        val movie4 = Movie("Lord of the Rings", "Frodo", "Fantasy", true)

        class NetworkAPI{
            fun getMovieData(): Observable<List<Movie>>{
                return Observable.just(listOf(movie1, movie2, movie3, movie4))
            }
        }

        val movieList = NetworkAPI().getMovieData()
        movieList.subscribe() {movieDetails -> println(movieDetails)}




        /*
            open class Person
            class Mark: Person()
            class Alan: Person()

            class NetworkAPI{
                fun getListOfPeople(): Observable<List<Person>>{
                    return Observable.just(listOf(Mark(), Alan()))
                }
            }

            val observable = Observable.just("Alpha", "Beta", "Gamma", "Delta")
            observable.subscribe() {string -> println("Returned: $string")}

            val personObservable = Observable.just(Mark(), Alan())
            personObservable.subscribe() {person -> println("Returned: $person")}
        */

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
