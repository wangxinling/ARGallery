package com.google.ar.core.examples.java.helloar.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.ui.person.PersonViewModel
import kotlinx.android.synthetic.main.fragment_order.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        personViewModel = ViewModelProvider(requireActivity()).get(PersonViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        orderNumber.text = personViewModel.orderData.id
        address_shipping.setText( personViewModel.orderData.address)
        postcode_shipping.setText(personViewModel.orderData.postcode)
        cityName_shipping.setText(personViewModel.orderData.city)
        phoneNumber.setText(personViewModel.orderData.phone)
        itemName.text = personViewModel.orderData.itemName
        confirm_button.setOnClickListener {
            findNavController().navigate(R.id.navigation_home)
        }
    }
}