package com.dolcegusto.nescafe.features.profile.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.app.data.model.Product
import com.dolcegusto.nescafe.databinding.ItemProductBinding

class ProductAdapter(
    private val context: Context,
    private val products: List<Product> = listOf()
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemProductBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product) {
            with (binding) {
                tvQuantity.text = context.getString(R.string.item_product_quantity, item.quantity)
                tvName.text = item.name
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), context
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        products.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int = products.size
}