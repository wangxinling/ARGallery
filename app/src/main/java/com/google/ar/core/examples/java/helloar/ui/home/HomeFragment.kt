package com.google.ar.core.examples.java.helloar.ui.home

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
//        var bitmapData = BitmapFactory.decodeResource(resources,R.drawable.daisy)
//        PlaceholderContent.bitmap =bitmapData

        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        })
        return root
    }

}