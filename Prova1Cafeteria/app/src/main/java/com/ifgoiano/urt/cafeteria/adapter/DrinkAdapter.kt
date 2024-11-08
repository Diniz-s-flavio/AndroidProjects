package com.ifgoiano.urt.cafeteria.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifgoiano.urt.cafeteria.R
import com.ifgoiano.urt.cafeteria.model.Drink

class DrinkAdapter(private val context: Context, private val drinks: List<Drink>?,private val onClickListener: DrinkOnClickListener)
    : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>()    {

    interface DrinkOnClickListener {
        fun onClickDrink(holder: DrinkViewHolder?, idx: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frame, parent, false)

        return DrinkViewHolder(view)
    }

    override fun getItemCount(): Int = drinks!!.size

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = drinks!![position]

        holder.tvItemFrameNome.text = drink.name

        holder.itemView.setOnClickListener{
            onClickListener.onClickDrink(holder, position)
        }
    }

    class DrinkViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvItemFrameNome: TextView  = view.findViewById(R.id.tvItemFrame)
    }

}