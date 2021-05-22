package com.example.uriatmosphere.component.stationview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uriatmosphere.R

class StationViewAdapter() : RecyclerView.Adapter<StationViewAdapter.StationViewHolder>() {
    val totalCount = 10;

    class StationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardTitle: TextView = itemView.findViewById(R.id.card_header_title)
        val cardClassification: ImageView = itemView.findViewById(R.id.card_header_icon)
        val cardIndex: TextView = itemView.findViewById(R.id.index)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val cardView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_station, parent, false)
        return StationViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        holder.cardTitle.text = "타이틀"
        holder.cardIndex.text = "${position + 1}/${totalCount}"
        if(position != 0)
            holder.cardClassification.setImageResource(R.drawable.ic_fluent_star_20_filled)
    }

    override fun getItemCount(): Int {
        return totalCount
    }
}