package com.google.ar.core.examples.java.helloar.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.databinding.CartRowBinding


class CartListAdapter(
    private var values: MutableList<CartItem>
) : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CartRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        if (item.product != null)
        {
            holder.idView.load(item.product.imgURL){
                crossfade(true)
                crossfade(2000)
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_error)
            }
            holder.contentView.text = item.product.content
            holder.priceView.text = item.product.price.toString() + "$"
        }

    }

    override fun getItemCount(): Int = values.size
    fun update(items:MutableList<CartItem>)
    {
        values = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: CartRowBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        val idView: ImageView = binding.productImageView
        val contentView: TextView = binding.textView
        val nameView:TextView = binding.productNameTextView
        val priceView: TextView = binding.productTotalPriceTextView
        val quantity:Spinner  = binding.quantitySpinner

//        init {
//            itemView.setOnClickListener(this)
//        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {

            }

        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }


}