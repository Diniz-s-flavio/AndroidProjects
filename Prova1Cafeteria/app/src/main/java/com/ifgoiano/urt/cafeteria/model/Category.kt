package com.ifgoiano.urt.cafeteria.model

data class Category (
    val name: String
)

object CategoryData {
    fun getCategory (): List<Category> {
        return listOf(
        Category("Bebidas"),
        Category("Comida"),
        Category("Mercearia")
        )
    }
}