package com.example.inheritanceempty

import android.graphics.Color

open class ShoppingItem(protected val productName: String, protected val colorId: Int) {
    val color = colorId
    val product = productName

    open fun getDisplayName(): String {
            return ""
    }
}

class GroceryItem(product: String, private val needsRefrigeration: Boolean) :
    ShoppingItem(productName = product, colorId = GROCERY_COLOR) {
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
    ShoppingItem(productName = product, colorId = CLOTHING_COLOR) {
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

class Tool(product: String, private val warrantyYears: Int) : ShoppingItem(productName = product, colorId = TOOL_COLOR) {
    companion object {
        const val TOOL_COLOR = Color.GRAY
    }

    override fun getDisplayName(): String {
        return "$warrantyYears Year Warranty"
    }
}