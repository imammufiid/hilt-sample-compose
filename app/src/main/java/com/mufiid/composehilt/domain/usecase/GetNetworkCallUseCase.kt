package com.mufiid.composehilt.domain.usecase

import com.mufiid.composehilt.domain.repository.MyRepository

class GetNetworkCallUseCase(
    private val repository: MyRepository
) {
    suspend operator fun invoke() {

    }
}