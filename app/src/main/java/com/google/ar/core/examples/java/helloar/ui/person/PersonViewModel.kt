package com.google.ar.core.examples.java.helloar.ui.person

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {

    var isLogin:MutableLiveData<Boolean> = MutableLiveData(false)
    lateinit var personData:PersonInformation
    lateinit var financialData:FinancialInformation
    lateinit var orderData:OrderInformation

    // The data could be from Database
    fun getDummyData()
    {
        personData = PersonInformation("001","Mike","Wang","mikewang@gmail.com","388 Murray Rd","3072","Preston","12346578")
        financialData = FinancialInformation("002","987654321","MikeWang","3369","12/2022")
        orderData = OrderInformation("003","388 Murray Rd","3072","Preston","1234567","Daisy")
    }
}
data class PersonInformation(val id: String, var firstName: String, var lastName: String, var email:String,
                             var address: String, var postcode: String, var city:String,  var phone: String) {
    override fun toString(): String = id
}
data class FinancialInformation(val id: String, var cardNumber: String, var holderName: String, var code: String,
                                var date:String){
    override fun toString(): String = id
}

data class OrderInformation(val id: String, var address: String, var postcode: String,
var city: String, var phone: String, var itemName:String) {
    override fun toString(): String = id
}