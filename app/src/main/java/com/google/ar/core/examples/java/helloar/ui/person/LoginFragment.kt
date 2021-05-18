package com.google.ar.core.examples.java.helloar.ui.person

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.ar.core.examples.java.helloar.HomeActivity
import com.google.ar.core.examples.java.helloar.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    private lateinit var btnLogin: Button
    private lateinit var btnForgot: Button
    private lateinit var btnSignUp: Button
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(
            requireActivity(),
            R.id.nav_host_fragment
        )
        btnLogin = view.findViewById(R.id.mBtnLogin)
        btnLogin.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java))
            requireActivity().finish()
        }
        btnForgot = view.findViewById(R.id.mBtnForgot)
        btnForgot.setOnClickListener {
            val email = mEtEmail.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToForgotFragment(email)
            navController.navigate(action)
        }
        btnSignUp = view.findViewById(R.id.mBtnRegister)
        btnSignUp.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}