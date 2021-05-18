package com.google.ar.core.examples.java.helloar.ui.home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.ar.core.examples.java.helloar.HomeActivity
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent
import com.google.ar.core.examples.java.helloar.ui.cart.CartViewModel
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()
    private lateinit var cartViewModel: CartViewModel
    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartViewModel = ViewModelProvider(requireActivity()).get(CartViewModel::class.java)


        val data = PlaceholderContent.ITEMS.get(args.itemIndex)
        view.findViewById<TextView>(R.id.detail_text).text = data.details
        view.findViewById<ImageView>(R.id.detail_imageView).load(data.imgURL)
        productNameTextView.text = data.content
        priceTextView.text = data.price.toString() + "$"
        button.setOnClickListener {
            cartViewModel.addItemToCart(data)
        }

    }

}