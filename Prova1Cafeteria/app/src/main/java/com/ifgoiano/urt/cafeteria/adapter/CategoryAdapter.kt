package com.ifgoiano.urt.cafeteria.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifgoiano.urt.cafeteria.R
import com.ifgoiano.urt.cafeteria.model.Category

class CategoryAdapter(private val context: Context, private val categoryList: List<Category>?,private val onClickListener: CategoryOnClickListener)
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>()    {

    interface CategoryOnClickListener {
        fun onClickCategory(holder: CategoryViewHolder?, idx: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frame, parent, false)

        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList!!.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList!![position]

        holder.tvItemFrameNome.text = category.name

        holder.itemView.setOnClickListener{
            onClickListener.onClickCategory(holder, position)
        }
    }

    class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvItemFrameNome: TextView  = view.findViewById(R.id.tvItemFrame)
    }

}