package com.google.ar.core.examples.java.helloar.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.databinding.CartRowBinding
import kotlinx.android.synthetic.main.cart_row.view.*
import kotlinx.android.synthetic.main.fragment_item.view.*


class CartListAdapter(
    private var values: MutableList<CartItem>,
    private var listener:OnItemClickListener

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
            holder.nameView.text = item.product.content
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
        val nameView:TextView = binding.productNameTextView
        val priceView: TextView = binding.productTotalPriceTextView
        init {
            itemView.deleteProductButton.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemClick(values[position])
            }

        }

        override fun toString(): String {
            return super.toString() + " '" + nameView.text + "'"
        }
    }
    interface  OnItemClickListener{
        fun onItemClick(item: CartItem)
    }


}