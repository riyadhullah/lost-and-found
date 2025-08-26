package com.ruit.lostandfound

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapterClass(private val items: List<CardDataClass>,
    private val onClaimClick: (CardDataClass) -> Unit,
    private val onImageClick: (CardDataClass) -> Unit
) : RecyclerView.Adapter<CardAdapterClass.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val itemLocation: TextView = itemView.findViewById(R.id.itemLocation)
        val itemDate: TextView = itemView.findViewById(R.id.itemDate)
        val btnClaim: Button = itemView.findViewById(R.id.btnClaim)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recent_lost_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = items[position]

        holder.itemImage.setImageResource(item.itemImage)
        holder.itemName.text = item.itemName
        holder.itemLocation.text = item.itemLocation
        holder.itemDate.text = item.itemDate


        holder.btnClaim.setOnClickListener {
            onClaimClick(item)
        }
        holder.itemImage.setOnClickListener {
            onImageClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
