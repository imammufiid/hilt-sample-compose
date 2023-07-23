package com.mufiid.composehilt.data.repository

import android.content.res.Resources
import com.mufiid.composehilt.data.remote.ApiInterface
import com.mufiid.composehilt.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: ApiInterface,
    private val resources: Resources
): MyRepository {
    override suspend fun doNetworkCall() {

    }
}