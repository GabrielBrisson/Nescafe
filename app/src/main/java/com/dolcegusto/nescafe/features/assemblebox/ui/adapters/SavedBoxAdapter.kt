package com.dolcegusto.nescafe.features.assemblebox.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dolcegusto.nescafe.databinding.ItemSavedBoxBinding
import com.dolcegusto.nescafe.features.assemblebox.data.model.SavedBox

class SavedBoxAdapter(
    private val savedBoxList : ArrayList<SavedBox>
) : RecyclerView.Adapter<SavedBoxAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ItemSavedBoxBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SavedBox) {
            // do the binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSavedBoxBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(savedBoxList[position])
    }

    override fun getItemCount(): Int = savedBoxList.size
}