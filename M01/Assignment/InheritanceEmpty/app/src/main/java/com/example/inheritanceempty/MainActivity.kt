package com.example.inheritanceempty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shoppingList: MutableList<ShoppingItem> = mutableListOf()

        fun addItem5Times(item: ShoppingItem){
            for(i in 0..4){
                shoppingList.add(item)
            }
        }

        val tool = Tool("Wrench", 10)
        val groceryItem = GroceryItem("Lettuce", true)
        val clothingItem = ClothingItem("Red T-Shirt", "Large")

        addItem5Times(tool)
        addItem5Times(groceryItem)
        addItem5Times((clothingItem))


        list.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list.layoutManager = manager
        val adapter = Recycler(shoppingList)
        list.adapter = adapter
        super.onResume()
    }
}
