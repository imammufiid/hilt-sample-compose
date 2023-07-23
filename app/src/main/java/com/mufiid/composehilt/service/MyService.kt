package com.mufiid.composehilt.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.mufiid.composehilt.presentation.home.interactor.HomeInteractor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyService: Service() {

    @Inject
    lateinit var homeInteractor: HomeInteractor

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}