package com.example.inheritanceempty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.items.view.*

class Recycler(private val shoppingItems: List<ShoppingItem>) :
    RecyclerView.Adapter<Recycler.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.product
        val display: TextView = view.display_name
        val background: LinearLayout = view.shopping_item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = shoppingItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = shoppingItems[position]
        holder.name.text = item.product
        holder.display.text = item.getDisplayName()
        holder.background.setBackgroundColor(item.color)
    }
}