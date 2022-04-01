package com.dolcegusto.nescafe.app.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.app.ui.viewmodel.SeeAllViewModel
import com.dolcegusto.nescafe.app.util.Enums
import com.dolcegusto.nescafe.databinding.ActivitySeeAllBinding
import com.dolcegusto.nescafe.features.profile.data.model.Order
import com.dolcegusto.nescafe.features.profile.ui.activities.OrderDetailsActivity
import com.dolcegusto.nescafe.features.profile.ui.adapter.OrderAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeeAllActivity : AppCompatActivity() {

    lateinit var binding: ActivitySeeAllBinding
    private val viewModel: SeeAllViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeeAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contentType = intent.extras?.getSerializable(SEE_ALL_TYPE) as Enums.SeeAllContentType
        contentType.let {
            viewModel.setType(it)
        }

        val content = intent.extras?.getSerializable(SEE_ALL_CONTENT) as ArrayList<*>?
        content?.let {
            viewModel.setContent(it)
        }

        setupUI()

    }

    private fun setupUI() {
        with(binding) {
            toolbar.setNavigationOnClickListener { onBackPressed() }

            when (viewModel.getContentType()) {
                Enums.SeeAllContentType.ORDER -> {
                    tvTitle.text = getString(R.string.my_orders)
                }
                else -> Unit
            }
        }
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recycler.layoutManager = LinearLayoutManager(this)

        when (viewModel.getContentType()) {
            Enums.SeeAllContentType.ORDER -> {
                viewModel.getOrderList().observe(this) {
                    it?.let { ordersList ->
                        val adapter = OrderAdapter(this, ordersList)
                        binding.recycler.adapter = adapter

                        adapter.onDetailsClickListener = { order ->
                            startOrderDetailsActivity(order)
                        }
                    }
                }
            }
            else -> Unit
        }
    }

    private fun startOrderDetailsActivity(order: Order) {
        val intent = Intent(this, OrderDetailsActivity::class.java)

        intent.putExtra(OrderDetailsActivity.ORDER, order)
        startActivity(intent)
    }

    companion object {
        const val SEE_ALL_TYPE = "see_all_content_type"
        const val SEE_ALL_CONTENT = "see_all_content"
    }
}