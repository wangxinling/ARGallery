package com.google.ar.core.examples.java.helloar.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.databinding.CartArRowBinding
import com.google.ar.core.examples.java.helloar.databinding.CartRowBinding
import kotlinx.android.synthetic.main.cart_row.view.*
import kotlinx.android.synthetic.main.fragment_item.view.*


class ARCartListAdapter(
    private var values: MutableList<CartItem>,
    private var listener:OnItemClickListener

) : RecyclerView.Adapter<ARCartListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CartArRowBinding.inflate(
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
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: CartArRowBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        val idView: ImageView = binding.productImageView
        init {
            idView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemClick(position, idView)
            }

        }

        override fun toString(): String {
            return super.toString() + "image"
        }
    }
    interface  OnItemClickListener{
        fun onItemClick(index:Int,item: ImageView)
    }


}