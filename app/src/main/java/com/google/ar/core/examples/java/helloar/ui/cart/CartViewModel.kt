package com.google.ar.core.examples.java.helloar.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.ar.core.examples.java.helloar.HomeActivity
import com.google.ar.core.examples.java.helloar.placeholder.PlaceholderContent
import java.util.ArrayList

class CartViewModel : ViewModel() {

    private var list:MutableList<CartItem> = ArrayList()
    var cartListLive: MutableLiveData<MutableList<CartItem>> = MutableLiveData()
    var totalPrice:MutableLiveData<Float> = MutableLiveData()

    fun addItemToCart(item: PlaceholderContent.PlaceholderItem) {
        list.add(CartItem(item))
        cartListLive.value = list
        updateTotalPrice()
    }
    fun removeItemFromCart(item:CartItem){
        list.remove(item)
        cartListLive.value = list
        updateTotalPrice()
    }
    private fun updateTotalPrice(){
        var totalP:Float  = 0.0F
        list.forEach { item->
            totalP += item.product.price
        }
        totalPrice.value = totalP
    }
}
data class CartItem(var product: PlaceholderContent.PlaceholderItem, var quantity:Int=1)