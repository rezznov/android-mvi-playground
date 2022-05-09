package com.reznov.android_mvi_playground.auth

sealed class LoginState{

    object Loading:LoginState()

    class FillForm(formData:LoginRequest?): LoginState()

    object ActionForm:LoginState()

    object RequestSuccess:LoginState()

    class RequestFailure(val message:String):LoginState()

}

data class LoginRequest(var userName:String, var passWord:String)

data class LoginResponse(var isLoggedIn:Boolean)