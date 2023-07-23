package com.mufiid.composehilt.presentation.home

import androidx.lifecycle.ViewModel
import com.mufiid.composehilt.presentation.home.interactor.HomeInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeInteractor: HomeInteractor,
): ViewModel() {
}