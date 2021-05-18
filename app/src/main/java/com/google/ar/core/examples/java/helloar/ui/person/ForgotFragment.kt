package com.google.ar.core.examples.java.helloar.ui.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.ar.core.examples.java.helloar.R
import kotlinx.android.synthetic.main.fragment_forgot.*


class ForgotFragment : Fragment() {
    lateinit var btnSubmit: Button
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forgot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(
            requireActivity(),
            R.id.nav_host_fragment
        )
        //set data in email EditText
        mETForgotEmail.setText(ForgotFragmentArgs.fromBundle(requireArguments()).email)
        btnSubmit = view.findViewById(R.id.mBtnSubmit)
        btnSubmit.setOnClickListener {
            navController.navigateUp()
        }
    }
}