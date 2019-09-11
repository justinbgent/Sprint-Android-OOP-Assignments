package com.example.betterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.betterapp.model.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var vehicles: ArrayList<Vehicle> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vehicles.add(Skateboard())
        vehicles.add(Car())
        vehicles.add(Airplane())
        vehicles.add(Unicycle())
        vehicles.add(Ripstick())
        vehicles.add(Boat())


        val clicker = View.OnClickListener {
            val fragment = DetailsFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.recycler, fragment)
                .commit()
        }

        recycler.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.layoutManager = manager
        val adapter = RecyclerAdapter(vehicles, clicker)
        recycler.adapter = adapter
    }
}
