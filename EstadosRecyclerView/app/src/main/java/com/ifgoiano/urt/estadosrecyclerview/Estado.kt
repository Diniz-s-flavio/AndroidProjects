package com.ifgoiano.urt.estadosrecyclerview

data class Estado(val nome: String, val img: Int)

object EstadoData {
    fun getEstados(): List<Estado> {
        return listOf(
            Estado("Acre", R.drawable.ac),
            Estado("Alagoas", R.drawable.al),
            Estado("Amapá", R.drawable.ap),
            Estado("Amazonas", R.drawable.am),
            Estado("Bahia", R.drawable.ba),
            Estado("Ceará", R.drawable.ce),
            Estado("Distrito Federal", R.drawable.df),
            Estado("Espírito Santo", R.drawable.es),
            Estado("Goiás", R.drawable.go),
            Estado("Maranhão", R.drawable.ma),
            Estado("Mato Grosso", R.drawable.mt),
            Estado("Mato Grosso do Sul", R.drawable.ms),
            Estado("Minas Gerais", R.drawable.mg),
            Estado("Pará", R.drawable.pa),
            Estado("Paraíba", R.drawable.pb),
            Estado("Paraná", R.drawable.pr),
            Estado("Pernambuco", R.drawable.pe),
            Estado("Piauí", R.drawable.pi),
            Estado("Rio de Janeiro", R.drawable.rj),
            Estado("Rio Grande do Norte", R.drawable.rn),
            Estado("Rio Grande do Sul", R.drawable.rs),
            Estado("Rondônia", R.drawable.ro),
            Estado("Roraima", R.drawable.rr),
            Estado("Santa Catarina", R.drawable.sc),
            Estado("São Paulo", R.drawable.sp),
            Estado("Sergipe", R.drawable.se),
            Estado("Tocantins", R.drawable.to)
        )
    }
}