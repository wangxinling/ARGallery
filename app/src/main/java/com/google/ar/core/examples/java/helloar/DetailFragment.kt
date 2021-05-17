package com.google.ar.core.examples.java.helloar

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
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent

class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()
    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val data = PlaceholderContent.ITEMS.get(args.itemIndex)
        view.findViewById<TextView>(R.id.detail_text).text = data.details
        view.findViewById<ImageView>(R.id.detail_imageView).load(data.imgURL)
    }
    fun jumpBack(view:View){
        Toast.makeText(context,"test",Toast.LENGTH_SHORT).show()
        val intent: Intent = Intent(this.context, HomeActivity::class.java)
        startActivity(intent)
    }

}