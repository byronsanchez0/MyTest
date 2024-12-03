package com.devkraken.mytest.features.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devkraken.mytest.Item
import com.devkraken.mytest.databinding.ItemLayoutBinding


class ItemAdapter(
    private val data: List<Item>,
    private val onUpdate: (Item) -> Unit,
    private val onDelete: (Item) -> Unit,
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item, onUpdate: (Item) -> Unit, onDelete: (Item) -> Unit) {
            binding.titleTextView.text = item.title
            binding.descriptionTextView.text = item.description
            binding.btnDelete.setOnClickListener {
                onDelete(item)
            }
            binding.root.setOnClickListener {
                onUpdate(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], onUpdate, onDelete)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}