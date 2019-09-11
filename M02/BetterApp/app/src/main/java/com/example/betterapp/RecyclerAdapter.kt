package com.example.betterapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.betterapp.model.Vehicle
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter(private val vehicles: ArrayList<Vehicle>, val clicker: View.OnClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = vehicles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = vehicles[position]

        holder.type.text = item.id

        holder.type.setOnClickListener(clicker)
//        holder.type.setOnClickListener {
//            val intent = Intent(context, MainActivity::class.java).apply {
//                putExtra("key", item)
//            }
//            context.startActivity(intent)
//        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val type: TextView = view.txt_vehicle
    }
}