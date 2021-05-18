package com.google.ar.core.examples.java.helloar.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent
import java.util.ArrayList

class CartViewModel : ViewModel() {

    private var list:MutableList<CartItem> = ArrayList()
    var cartListLive: MutableLiveData<MutableList<CartItem>> = MutableLiveData()

    fun addItemToCart(item: PlaceholderContent.PlaceholderItem) {
        list.add(CartItem(item))
        cartListLive.value = list
    }
}
data class CartItem(var product: PlaceholderContent.PlaceholderItem, var quantity:Int=1)