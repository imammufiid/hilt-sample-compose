package com.mufiid.composehilt.data.remote

import retrofit2.http.GET

interface ApiInterface {
    @GET("test")
    suspend fun doNetworkCall()
}