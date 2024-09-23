package com.ifgoiano.urt.beerselector

class ExpertCerveja {
    public fun getMarcas(color: String): List<String> {
        return when (color) {
            "Pilsen" -> listOf("Skol", "Brahma", "Heineken")
            "IPA" -> listOf("Colorado Indica", "Dogma", "Goose Island")
            "Stout" -> listOf("Guinness", "Colorado Demoiselle", "Murphy's")
            "Lager" -> listOf("Budweiser", "Corona", "Stella Artois")
            "Weiss" -> listOf("Erdinger", "Franziskaner", "Weihenstephaner")
            else -> listOf("Sem marcas disponíveis")
        }
    }
}