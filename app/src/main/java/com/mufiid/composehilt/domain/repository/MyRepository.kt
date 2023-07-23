package com.mufiid.composehilt.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()

}