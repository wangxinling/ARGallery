package com.google.ar.core.examples.java.helloar.ui.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.ar.core.examples.java.helloar.R
import kotlinx.android.synthetic.main.fragment_account.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    private lateinit var personViewModel: PersonViewModel


    override fun onStart() {
        super.onStart()
        if(personViewModel.isLogin.value == false)
        {
            val action = AccountFragmentDirections.actionAccountFragmentToNavigationLogin()
            findNavController().navigate(action)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        accountBtn.setOnClickListener {
            val action = AccountFragmentDirections.actionAccountFragmentToPersonFragment()
            findNavController().navigate(action)
        }
        ordersBtn.setOnClickListener {
            val action = AccountFragmentDirections.actionAccountFragmentToOrderFragment()
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personViewModel = ViewModelProvider(requireActivity()).get(PersonViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }


}