package com.reznov.android_mvi_playground.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loginResponseLiveData: MutableLiveData<LoginState> = MutableLiveData(LoginState.FillForm(null))

    fun login(loginRequest: LoginRequest) = viewModelScope.launch {
        loginResponseLiveData.value = LoginState.Loading

        val response = LoginRepository.login(loginRequest)

        if (response.isLoggedIn) {
            loginResponseLiveData.value = LoginState.RequestSuccess
        } else {
            loginResponseLiveData.value = LoginState.RequestFailure("Fake Server Message!")
        }


    }

}