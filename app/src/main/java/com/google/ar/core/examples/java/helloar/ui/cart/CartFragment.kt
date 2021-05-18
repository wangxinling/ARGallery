package com.google.ar.core.examples.java.helloar.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent
import kotlinx.android.synthetic.main.fragment_cart.*
import java.util.ArrayList

class CartFragment : Fragment() {

    private lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        cartViewModel = ViewModelProvider(requireActivity()).get(CartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cart, container, false)

        // Set the adapter


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cartAdapter = if (cartViewModel.cartListLive.value == null) {
            CartListAdapter( ArrayList<CartItem>())
        } else {
            CartListAdapter(cartViewModel.cartListLive.value!!)
        }

        cartRecyclerView.hasFixedSize()
        cartRecyclerView.adapter = cartAdapter

        cartViewModel.cartListLive.observe(viewLifecycleOwner, Observer {
            cartAdapter.update(it)
        })
    }
}