package com.example.quizapp.data.api

import com.example.quizapp.Utilities
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Utilities.URL)
    .build()


object AppApi {
    val quizApi :AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }
}


//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//private val retrofit = Retrofit.Builder()
//
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(Utilities.URL)
//    .build()
//
//object AppApi{
//    val retrofitService by lazy {
//        retrofit.create(AppApiService::class.java)
//    }
//}