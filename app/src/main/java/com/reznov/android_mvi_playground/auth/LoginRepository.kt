package com.reznov.android_mvi_playground.auth

import kotlinx.coroutines.delay

object LoginRepository {

    suspend fun login(request:LoginRequest): LoginResponse{
        delay(2000)
        return LoginResponse(true)
    }

}