package com.dolcegusto.nescafe.features.profile.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.app.util.Enums
import com.dolcegusto.nescafe.app.util.toDateFormat
import com.dolcegusto.nescafe.databinding.ActivityOrderDetailsBinding
import com.dolcegusto.nescafe.features.profile.data.model.Order
import com.dolcegusto.nescafe.features.profile.ui.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OrderDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityOrderDetailsBinding
    private val viewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.setOrder(intent.extras?.getSerializable("order") as Order)

        setupOrderCardUI()
        setupToolbar()

    }

    private fun setupToolbar() {
        val order = viewModel.getOrder()

        order?.let {
            binding.tvTitle.text = getString(R.string.order_detail_title, order.number)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupOrderCardUI() {
        val order = viewModel.getOrder()

        order?.let {
            with(binding) {
                tvOrderTitle.text = getString(R.string.order_detail_title, order.number)
                tvOrderDate.text = getString(R.string.order_card_date, order.date.toDateFormat())
                tvOrderTotalPrice.text = getString(R.string.order_card_total_price, order.totalPrice.toString())
                tvTrackNumber.text = getString(R.string.track_number, order.trackNumber)
                tvTrackNumber.setOnClickListener {
                    openTrackNumberWebsite(order.trackNumber)
                }

                when (order.status) {
                    Enums.OrderStatus.WAITING_CREDIT_CARD_CONFIRMATION -> {
                        tvOrderStatus.text =
                            getString(R.string.order_status_waiting_credit_card_confirmation)
                        viewStatus1.background = AppCompatResources.getDrawable(
                            applicationContext,
                            R.color.waiting_credit_card_confirmation
                        )
                    }
                    Enums.OrderStatus.SEPARATION_PROCESS -> {
                        tvOrderStatus.text = getString(R.string.order_status_separation_process)
                        with(
                            AppCompatResources.getDrawable(
                                applicationContext,
                                R.color.separation_process
                            )
                        ) {
                            viewStatus1.background = this
                            binding.viewStatus2.background = this
                        }
                    }
                    Enums.OrderStatus.IN_TRANSIT -> {
                        tvOrderStatus.text = getString(R.string.order_status_in_transit)
                        with(
                            AppCompatResources.getDrawable(
                                applicationContext,
                                R.color.in_transit
                            )
                        ) {
                            viewStatus1.background = this
                            viewStatus2.background = this
                            viewStatus3.background = this
                        }
                    }
                    Enums.OrderStatus.SENT -> {
                        tvOrderStatus.text = getString(R.string.order_status_in_sent)
                        with(AppCompatResources.getDrawable(applicationContext, R.color.sent)) {
                            viewStatus1.background = this
                            viewStatus2.background = this
                            viewStatus3.background = this
                            viewStatus4.background = this
                        }
                    }
                }

            }
        }

    }

    private fun openTrackNumberWebsite(tracNumber: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ondeestameupedido.com.br/${tracNumber}"))
        startActivity(browserIntent)
    }
}