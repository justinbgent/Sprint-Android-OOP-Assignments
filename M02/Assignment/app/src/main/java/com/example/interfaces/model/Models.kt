package com.example.interfaces.model

import android.os.Parcelable

abstract class Vehicle(val id: String, val weight: Int, var favorite: Boolean): Parcelable{
    abstract fun travel(): String
}

interface AirTravel{
    fun fly(): String
}

interface WaterTravel{
    fun sail(): String
}

interface GroundTravel{
    fun drive(): String
}

class Airplane(id: String = "Airplane", weight: Int = 130000, favorite: Boolean = false): Vehicle(id, weight, favorite), AirTravel{
    override fun travel(): String {
        return "$id travels via ${fly()}"
    }

    override fun fly(): String {
        return "sky"
    }
}

class Car(id: String = "Car", weight: Int = 3500, favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive(): String {
        return "ground"
    }
}

class Boat(id: String = "SpeedBoat", weight: Int = 8000, favorite: Boolean = false): Vehicle(id, weight, favorite), WaterTravel{
    override fun travel(): String {
        return "$id travels via ${sail()}"
    }

    override fun sail(): String {
        return "water"
    }
}

class Skateboard(id: String = "Skateboard", weight: Int = 10, favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive(): String {
        return "ground"
    }
}

class Ripstick(id: String = "Ripstick", weight: Int = 15, favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive(): String {
        return "ground"
    }
}

class Unicycle(id: String = "Unicycle", weight: Int = 25, favorite: Boolean = false): Vehicle(id, weight, favorite), GroundTravel{
    override fun travel(): String {
        return "$id travels via ${drive()}"
    }

    override fun drive(): String {
        return "ground"
    }
}