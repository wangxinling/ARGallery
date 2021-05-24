package com.google.ar.core.examples.java.helloar.ui.person

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {

    var isLogin:MutableLiveData<Boolean> = MutableLiveData(false)
}
data class PersonInformation(val id: String, val content: String, val details: String,@DrawableRes
val image: Int?, val price: Float, val imgURL:String) {
    override fun toString(): String = content
}