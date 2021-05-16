package com.google.ar.core.examples.java.helloar

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load

import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent.PlaceholderItem
import com.google.ar.core.examples.java.helloar.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyPictureRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<MyPictureRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        if (item.image != null)
        {
            holder.idView.load(item.imgURL){
                crossfade(true)
                crossfade(2000)
                placeholder(item.image)
                error(R.drawable.ic_error)
            }
            //holder.idView.setImageResource(item.image)

        }
        holder.contentView.text = item.content
        holder.priceView.text = item.price.toString() + "$"
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root),
    View.OnClickListener {
        val idView: ImageView = binding.pictureImage
        val contentView: TextView = binding.content
        val priceView:TextView = binding.price

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.onItemClick(position)
            }

        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
    interface  OnItemClickListener{
        fun onItemClick(position: Int)
    }

}