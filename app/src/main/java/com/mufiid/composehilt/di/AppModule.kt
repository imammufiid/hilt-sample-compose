package com.mufiid.composehilt.di

import android.content.Context
import android.content.res.Resources
import com.mufiid.composehilt.data.remote.ApiInterface
import com.mufiid.composehilt.data.repository.MyRepositoryImpl
import com.mufiid.composehilt.di.annotation.BaseUrlServerA
import com.mufiid.composehilt.di.annotation.BaseUrlServerB
import com.mufiid.composehilt.domain.repository.MyRepository
import com.mufiid.composehilt.domain.usecase.GetNetworkCallUseCase
import com.mufiid.composehilt.presentation.home.interactor.HomeInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideResource(
        @ApplicationContext context: Context,
    ): Resources {
        return context.resources
    }
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @BaseUrlServerA
    @Provides
    @Singleton
    fun provideRetrofitServerA(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://testa.com")
            .build()
    }

    @BaseUrlServerB
    @Provides
    @Singleton
    fun provideRetrofitServerB(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://testb.com")
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(
        @BaseUrlServerA retrofit: Retrofit,
    ): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}

/**
 * 1st way to create dependency
 */
/*@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMyRepository(apiInterface: ApiInterface, resources: Resources): MyRepository {
        return MyRepositoryImpl(api = apiInterface, resources = resources)
    }
}*/

/**
 * 2nd way to create dependency using @Bind
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMyRepository(myRepositoryImpl: MyRepositoryImpl): MyRepository
}

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideHomeInteractor(repository: MyRepository): HomeInteractor {
        return HomeInteractor(
            getNetworkCallUseCase = GetNetworkCallUseCase(repository = repository)
        )
    }
}