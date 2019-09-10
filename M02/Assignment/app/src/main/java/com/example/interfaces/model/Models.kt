package com.example.interfaces.model

abstract class Vehicle(id: String, weight: Int, favorite: Boolean){
    abstract fun travel(): String
}

interface AirTravel{
    fun fly()
}

interface WaterTravel{
    fun sail()
}

interface GroundTravel{
    fun drive()
}

class Airplane(val id: String = "Airplane", val weight: Int = 130000, val favorite: Boolean = false): Vehicle(id, weight, favorite), AirTravel{
    override fun travel(): String {
        return "$id travels via ${fly()}"
    }

    override fun fly() {

    }
}

class Car(val id: String = "Car", val weight: Int = 3500, val favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive() {
    }
}

class Boat(val id: String = "Boat", val weight: Int = 8000, val favorite: Boolean = false): Vehicle(id, weight, favorite), WaterTravel{
    override fun travel(): String {
        return "$id travels via ${sail()}"
    }

    override fun sail() {
    }
}

class Skateboard(val id: String = "Skateboard", val weight: Int = 10, val favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive() {
    }
}

class Ripstick(val id: String = "Ripstick", val weight: Int = 15, val favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive() {
    }
}

class Unicycle(val id: String = "Unicycle", val weight: Int = 25, val favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive() {
    }
}