package com.ifgoiano.urt.estadosrecyclerview

data class Estado(val nome: String, val img: Int, val capital: String, val populacao: String, val regiao: String)

object EstadoData {
    fun getEstados(): List<Estado> {
        return listOf(
            Estado("Acre", R.drawable.ac, "Rio Branco", "881.935", "Norte"),
            Estado("Alagoas", R.drawable.al, "Maceió", "3.351.543", "Nordeste"),
            Estado("Amapá", R.drawable.ap, "Macapá", "845.731", "Norte"),
            Estado("Amazonas", R.drawable.am, "Manaus", "4.207.714", "Norte"),
            Estado("Bahia", R.drawable.ba, "Salvador", "14.873.064", "Nordeste"),
            Estado("Ceará", R.drawable.ce, "Fortaleza", "9.132.078", "Nordeste"),
            Estado("Distrito Federal", R.drawable.df, "Brasília", "3.055.149", "Centro-Oeste"),
            Estado("Espírito Santo", R.drawable.es, "Vitória", "4.064.052", "Sudeste"),
            Estado("Goiás", R.drawable.go, "Goiânia", "7.113.540", "Centro-Oeste"),
            Estado("Maranhão", R.drawable.ma, "São Luís", "7.075.181", "Nordeste"),
            Estado("Mato Grosso", R.drawable.mt, "Cuiabá", "3.526.220", "Centro-Oeste"),
            Estado("Mato Grosso do Sul", R.drawable.ms, "Campo Grande", "2.809.394", "Centro-Oeste"),
            Estado("Minas Gerais", R.drawable.mg, "Belo Horizonte", "21.292.666", "Sudeste"),
            Estado("Pará", R.drawable.pa, "Belém", "8.690.745", "Norte"),
            Estado("Paraíba", R.drawable.pb, "João Pessoa", "4.039.277", "Nordeste"),
            Estado("Paraná", R.drawable.pr, "Curitiba", "11.516.840", "Sul"),
            Estado("Pernambuco", R.drawable.pe, "Recife", "9.616.621", "Nordeste"),
            Estado("Piauí", R.drawable.pi, "Teresina", "3.281.480", "Nordeste"),
            Estado("Rio de Janeiro", R.drawable.rj, "Rio de Janeiro", "17.366.189", "Sudeste"),
            Estado("Rio Grande do Norte", R.drawable.rn, "Natal", "3.534.165", "Nordeste"),
            Estado("Rio Grande do Sul", R.drawable.rs, "Porto Alegre", "11.422.973", "Sul"),
            Estado("Rondônia", R.drawable.ro, "Porto Velho", "1.796.460", "Norte"),
            Estado("Roraima", R.drawable.rr, "Boa Vista", "631.181", "Norte"),
            Estado("Santa Catarina", R.drawable.sc, "Florianópolis", "7.252.502", "Sul"),
            Estado("São Paulo", R.drawable.sp, "São Paulo", "46.289.333", "Sudeste"),
            Estado("Sergipe", R.drawable.se, "Aracaju", "2.318.822", "Nordeste"),
            Estado("Tocantins", R.drawable.to, "Palmas", "1.590.248", "Norte")
        )
    }
}