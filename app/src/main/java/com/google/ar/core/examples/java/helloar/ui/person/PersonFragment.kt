package com.google.ar.core.examples.java.helloar.ui.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.ar.core.examples.java.helloar.R
import kotlinx.android.synthetic.main.fragment_person.*

class PersonFragment : Fragment() {
    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        personViewModel = ViewModelProvider(requireActivity()).get(PersonViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profile_firstName.setText(personViewModel.personData.firstName)
        profile_lastName.setText(personViewModel.personData.lastName)
        addressProfile.setText(personViewModel.personData.address)
        profile_cityName.setText(personViewModel.personData.city)
        addressPostcode.setText(personViewModel.personData.postcode)
        profile_phone.setText(personViewModel.personData.phone)

        finanical_ID.setText(personViewModel.financialData.id)
        finanical_name.setText(personViewModel.financialData.holderName)
        finanical_code.setText(personViewModel.financialData.code)
        finanical_data.setText(personViewModel.financialData.date)

    }
}