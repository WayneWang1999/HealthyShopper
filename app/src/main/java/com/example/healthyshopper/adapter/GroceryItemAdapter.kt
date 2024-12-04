package com.example.healthyshopper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyshopper.databinding.GroceryItemBinding
import com.example.healthyshopper.model.GroceryItem

class GroceryItemAdapter(private var items: List<GroceryItem>) :
    RecyclerView.Adapter<GroceryItemAdapter.GroceryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryItemViewHolder {
        val binding = GroceryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroceryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroceryItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class GroceryItemViewHolder(private val binding: GroceryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GroceryItem) {
            binding.tvItemName.text = item.itemName
        }
    }
//DIIIIIIIII, add updateData funtion in the adapter.
    fun updateData(newItems: List<GroceryItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}


