package com.ifgoiano.urt.cafeteria.model

import com.ifgoiano.urt.cafeteria.R

data class Drink(
    val name: String,
    val descricao: String,
    val img: Int
)

object DrinkData{
    fun getDrinkList(): List<Drink> {
        return listOf(
            Drink("Espresso", "Um café forte e concentrado feito ao forçar água quente através de café \n" +
                    "moído fino. Base de várias outras bebidas de café.", R.drawable.expresso
            ),
            Drink("Cappuccino", "Combina espresso com partes iguais de leite vaporizado e espuma de \n" +
                    "leite. Famoso pelo equilíbrio entre sabores ricos e textura cremosa.", R.drawable.cappucino
            ),
            Drink("Latte", "Uma dose de espresso com uma quantidade generosa de leite vaporizado \n" +
                    "e uma pequena camada de espuma por cima. Suave e levemente \n" +
                    "adocicado.", R.drawable.latte
            ),
            Drink("Americano", "Espresso diluído com água quente, resultando em um café mais suave e \n" +
                    "menos intenso. Popular entre quem gosta de sabores menos \n" +
                    "concentrados.\n", R.drawable.americano
            ),
            Drink("Mocha", "Mistura de espresso com leite vaporizado e uma dose de chocolate. \n" +
                    "Geralmente coberto com chantilly e popular entre os amantes de \n" +
                    "chocolate.", R.drawable.mocha
            ),
            Drink("Macchiato", "Espresso “manchado” com um pouco de espuma de leite, acentuando o \n" +
                    "sabor forte do café com apenas um toque de suavidade.\n", R.drawable.macchiato
            ),
            Drink("Flat White", "Similar ao cappuccino, mas com menos espuma e uma proporção maior \n" +
                    "de leite. De origem australiana, tem sabor intenso e textura sedosa.\n", R.drawable.flatwhite
            ),
            Drink("Ristretto", "Uma dose de espresso mais concentrada e curta, com sabor mais denso \n" +
                    "e encorpado. Ideal para quem gosta de café intenso.\n", R.drawable.ristreto
            ),
            Drink("Affogato", "Uma sobremesa italiana que combina espresso quente sobre uma bola de \n" +
                    "sorvete de baunilha. Uma deliciosa fusão de quente e frio.", R.drawable.affogato
            ),
            Drink("Cold Brew", "Uma sobremesa italiana que combina espresso quente sobre uma bola de \n" +
                    "sorvete de baunilha. Uma deliciosa fusão de quente e frio.", R.drawable.coldbrew
            )
        )
    }
}
