package com.example.inheritanceempty

import android.graphics.Color

abstract class ShoppingItem(protected val productName: String, protected val colorId: Int) {
    val color = colorId

    open fun getDisplayName(): String {
        val display = ""
        return display
    }
}

class GroceryItem(product: String, private val needsRefrigeration: Boolean) :
    ShoppingItem(productName = "GroceryItem", colorId = GROCERY_COLOR) {
    companion object {
        const val GROCERY_COLOR = Color.GREEN
    }

    override fun getDisplayName(): String {
        return if (needsRefrigeration) {
            "Refrigerate"
        } else {
            ""
        }

    }
}

class ClothingItem(product: String, private val size: String) :
    ShoppingItem(productName = "ClothingItem", colorId = CLOTHING_COLOR) {
    companion object {
        const val CLOTHING_COLOR = Color.RED
    }

    override fun getDisplayName(): String {
        return when (size) {
            "Large" -> ("Large")
            "Medium" -> ("Medium")
            "Small" -> ("Small")
            else -> ("")
        }
    }
}

class Tool(product: String) : ShoppingItem(productName = "Tool", colorId = TOOL_COLOR) {
    companion object {
        const val TOOL_COLOR = Color.GRAY
    }

    override fun getDisplayName(warrantyYears: String): String {
        return "$warrantyYears Year Warranty"
    }
}