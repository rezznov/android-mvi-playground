package com.reznov.android_mvi_playground.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.reznov.android_mvi_playground.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    private var _binding:FragmentLoginBinding? = null
    val binding:FragmentLoginBinding get() = _binding!!

    val viewModel:LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResponseLiveData.observe(viewLifecycleOwner){
            render(it)
        }
    }


    private fun render(state:LoginState){
        when(state){
            LoginState.Loading->{
                //show loading
            }
            LoginState.RequestSuccess->{
                //navigate to home
            }
            is LoginState.RequestFailure->{
                //show error message
                Toast.makeText(requireContext(),state.message,Toast.LENGTH_LONG).show()
            }
        }
    }

    fun intentLogin(){
//        viewModel.login()
    }




}