package com.mufiid.composehilt.presentation.home.interactor

import com.mufiid.composehilt.domain.usecase.GetNetworkCallUseCase

data class HomeInteractor(
    val getNetworkCallUseCase: GetNetworkCallUseCase,
)
