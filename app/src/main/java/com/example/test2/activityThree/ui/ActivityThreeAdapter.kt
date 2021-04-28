package com.example.test2.activityThree.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R
import com.example.test2.data.dto.ProductItem
import com.squareup.picasso.Picasso

class ActivityThreeAdapter : RecyclerView.Adapter<ActivityThreeAdapter.ExampleViewHolder>() {

    private val items = mutableListOf<ProductItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val exampleViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ExampleViewHolder(exampleViewHolder)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount() = items.size

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(items: ProductItem) {
            val picture: ImageView = itemView.findViewById(R.id.img_list)
            val txtItem: TextView = itemView.findViewById(R.id.txt_item)
            txtItem.text = items.text
            if (items.image.isEmpty()) {
                picture.setImageResource(R.drawable.ic_launcher_background)
            } else
                Picasso.with(itemView.context)
                    .load(items.image)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .fit()
                    .into(picture)
        }
    }
     fun setItems(newItems: List<ProductItem>) {
         items.clear()
         items.addAll(newItems)
     }
}

