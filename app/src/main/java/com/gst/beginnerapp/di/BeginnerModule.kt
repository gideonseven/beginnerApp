package com.gst.beginnerapp.di

import com.gst.beginnerapp.retrofit.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


/**
 * Created by gideon on 9/5/2022
 * gideon@cicil.co.id
 * https://www.cicil.co.id/
 */

@Module
@InstallIn(SingletonComponent::class)
object BeginnerModule {
    private const val BASE_URL = "https://www.balldontlie.io/api/v1/"

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        // ... add your own JsonAdapters and factories ...
        // for parsing object inside arrayobject if not use, its gonna make object null
        .add(KotlinJsonAdapterFactory())
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()


    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit,
    ): ApiService {
        return retrofit.newBuilder().build().create(
            ApiService::class.java
        )
    }
}