package com.dolcegusto.nescafe.features.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.dolcegusto.nescafe.databinding.ItemViewPagerBinding

class ViewPageAdapter(private val images: List<Int>) :
    RecyclerView.Adapter<ViewPageAdapter.ViewPageViewHolder>() {

    inner class ViewPageViewHolder(private val binding: ItemViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int) {
            binding.ivViewPagerImage.setImageResource(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageViewHolder {
        val view = ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPageViewHolder, position: Int) {
        holder.bind(images[position])

    }

    override fun getItemCount(): Int {
        return images.size
    }

}
