// LogoAdapter.kt

package com.example.geekgenius.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.geekgenius.R

class KampusAdapter(private val logoList: List<Int>, private val itemClickListener: (Int) -> Unit) : RecyclerView.Adapter<KampusAdapter.LogoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo_kampus, parent, false)
        return LogoViewHolder(view)
    }

    override fun onBindViewHolder(holder: LogoViewHolder, position: Int) {
        holder.bind(logoList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(logoList[position])
        }
    }

    override fun getItemCount(): Int = logoList.size

    class LogoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val logoImageView: ImageView = itemView.findViewById(R.id.logoImageView)

        fun bind(logoResId: Int) {
            logoImageView.setImageResource(logoResId)
        }
    }
}
