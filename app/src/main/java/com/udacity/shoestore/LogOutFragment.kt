package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLogOutBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding


// Obsolete class, see comments in fragment_logout.xml
class LogOutFragment : Fragment() {

    //private lateinit var binding: FragmentLogOutBinding

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_log_out, container, false
        )
        binding.logoutButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_logOutFragment_to_loginFragment)
        )
        // Inflate the layout for this fragment
        return binding.root
    }*/

}