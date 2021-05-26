package com.google.ar.core.examples.java.helloar.ui.home


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent
import com.google.ar.core.examples.java.helloar.ui.cart.CartViewModel
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.coroutines.launch

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
    private suspend fun getBitmap(url:String): Bitmap {
        val loading = ImageLoader(requireContext())
        val request = ImageRequest.Builder(requireContext())
                .data(url)
                .build()
        val result = (loading.execute(request) as SuccessResult).drawable

        return (result as BitmapDrawable).bitmap
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
            //Jump to cart
            val action = DetailFragmentDirections.actionNavigationDetailToNavigationDashboard()
            findNavController().navigate(action)
            //Load image to Bitmap
            lifecycleScope.launch{
                //PlaceholderContent.bitmap = getBitmap(data.imgURL)
                PlaceholderContent.bitmap =(detail_imageView.getDrawable() as BitmapDrawable).bitmap
            }
        }

    }

}