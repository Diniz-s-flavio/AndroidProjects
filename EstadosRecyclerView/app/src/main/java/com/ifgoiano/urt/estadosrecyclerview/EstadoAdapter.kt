package com.ifgoiano.urt.estadosrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EstadoAdapter(
    private val context: Context,
    private val estados: List<Estado>?,
    private val onClickListener: EstadoOnCLickListener
) :
    RecyclerView.Adapter<EstadoAdapter.EstadosViewHolder>(){

    interface EstadoOnCLickListener {
        fun onClickEstado(holder: EstadosViewHolder?, idx: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): EstadosViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.adapter_estado,viewGroup, false)

        return EstadosViewHolder(view)
    }

    override fun getItemCount(): Int = estados!!.size

    override fun onBindViewHolder(holder: EstadosViewHolder, position: Int) {
         val estado =  estados!![position]

        holder.tNome.text = estado.nome
        holder.img.setImageResource(estado.img)

        holder.itemView.setOnClickListener{
            onClickListener.onClickEstado(holder, position)
        }
    }

    class EstadosViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var tNome: TextView =  view.findViewById(R.id.tNomeEstado)
        var img: ImageView = view.findViewById(R.id.img)
    }


}
