package com.dolcegusto.nescafe.features.profile.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.app.util.Enums
import com.dolcegusto.nescafe.app.util.toDateFormat
import com.dolcegusto.nescafe.databinding.ItemOrderBinding
import com.dolcegusto.nescafe.features.profile.data.model.Order
import java.util.*

class OrderAdapter(
    private val context: Context,
    private val orderList: List<Order> = listOf()
    ) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    lateinit var onDetailsClickListener: (item: Order) -> Unit?

    class ViewHolder(
        private val binding: ItemOrderBinding,
        private val context: Context,
        private val onDetailsClickListener: (item: Order) -> Unit?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Order) {
            binding.tvOrderTitle.text = context.getString(R.string.order_card_date, item.number)
            binding.tvOrderDate.text = context.getString(R.string.order_card_date, item.date.toDateFormat())
            binding.tvOrderTotalPrice.text = context.getString(R.string.order_card_total_price, item.totalPrice.toString())

            when (item.status) {
                Enums.OrderStatus.WAITING_CREDIT_CARD_CONFIRMATION -> {
                    binding.tvOrderStatus.text = context.getString(R.string.order_status_waiting_credit_card_confirmation)
                    binding.viewStatus1.background = context.getDrawable(R.color.waiting_credit_card_confirmation)
                }
                Enums.OrderStatus.SEPARATION_PROCESS -> {
                    binding.tvOrderStatus.text = context.getString(R.string.order_status_separation_process)
                    with (context.resources.getDrawable(R.color.separation_process, null)) {
                        binding.viewStatus1.background = this
                        binding.viewStatus2.background = this
                    }
                }
                Enums.OrderStatus.IN_TRANSIT -> {
                    binding.tvOrderStatus.text = context.getString(R.string.order_status_in_transit)
                    with (context.resources.getDrawable(R.color.in_transit, null)) {
                        binding.viewStatus1.background = this
                        binding.viewStatus2.background = this
                        binding.viewStatus3.background = this
                    }
                }
                Enums.OrderStatus.SENT -> {
                    binding.tvOrderStatus.text = context.getString(R.string.order_status_in_sent)
                    with (context.resources.getDrawable(R.color.sent, null)) {
                        binding.viewStatus1.background = this
                        binding.viewStatus2.background = this
                        binding.viewStatus3.background = this
                        binding.viewStatus4.background = this
                    }
                }
            }

            binding.btDetails.setOnClickListener {
                onDetailsClickListener.invoke(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOrderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            context,
            onDetailsClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(orderList[position])
    }

    override fun getItemCount(): Int = orderList.size

}