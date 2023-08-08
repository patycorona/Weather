package com.example.weather.platform.di.module

import com.example.weather.data.network.Constant.Companion.URL_BASE
import com.example.weather.data.network.CoreServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(ViewModelComponent::class)
@Module
object RetrofitModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideCoreHomeApi(retrofit: Retrofit): CoreServiceApi {
        return retrofit.create(CoreServiceApi::class.java)
    }
}
