package com.dolcegusto.nescafe.features.profile.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dolcegusto.nescafe.R
import com.dolcegusto.nescafe.app.ui.activities.SeeAllActivity
import com.dolcegusto.nescafe.app.util.Enums
import com.dolcegusto.nescafe.databinding.FragmentProfileBinding
import com.dolcegusto.nescafe.features.profile.data.model.Order
import com.dolcegusto.nescafe.features.profile.ui.activities.AccountInfoActivity
import com.dolcegusto.nescafe.features.profile.ui.activities.OrderDetailsActivity
import com.dolcegusto.nescafe.features.profile.ui.adapter.OrderAdapter
import com.dolcegusto.nescafe.features.profile.ui.viewmodels.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    private lateinit var adapter: OrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        setupUI()
        setupOrdersUI()

        return binding.root
    }

    private fun setupUI() {
        with(binding) {
            val user = viewModel.user

            tvUserName.text = user.fullName
            tvFidelityPoints.text = getString(R.string.fidelity_points, user.fidelityPoints.toString())
            tvSeeAllOrders.setOnClickListener {
                startSeeAllActivity(ArrayList(viewModel.orders))
            }

            layoutAccountInfo.setOnClickListener {
                val i = Intent(requireContext(), AccountInfoActivity::class.java)
                startActivity(i)
            }
        }
    }

    private fun setupOrdersUI() {
        // showing only 2 first orders
        val orders = viewModel.orders
        if (orders.size > 2) {
            binding.tvSeeAllOrders.visibility = View.VISIBLE

            val newOrders: List<Order> = listOf(orders[0], orders[1])
            adapter = OrderAdapter(requireContext(), newOrders)
        } else {
            binding.tvSeeAllOrders.visibility = View.GONE

            adapter = OrderAdapter(requireContext(), orders)
        }

        binding.recyclerOrder.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerOrder.adapter = adapter

        adapter.onDetailsClickListener = { order ->
            startOrderDetailActivity(order)
        }

    }

    private fun startOrderDetailActivity(order: Order?) {
        val intent = Intent(requireContext(), OrderDetailsActivity::class.java)

        intent.putExtra(OrderDetailsActivity.ORDER, order)
        startActivity(intent)
    }

    private fun startSeeAllActivity(orderList: ArrayList<Order>?) {
        val intent = Intent(requireContext(), SeeAllActivity::class.java)

        intent.putExtra(SeeAllActivity.SEE_ALL_TYPE, Enums.SeeAllContentType.ORDER)
        intent.putExtra(SeeAllActivity.SEE_ALL_CONTENT, orderList)
        startActivity(intent)
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}