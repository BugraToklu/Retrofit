package com.bugratoklu.retrofit.data


import com.bugratoklu.retrofit.Model.Post
import io.reactivex.Observer
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class Service {

    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(API::class.java)

    fun getPosts(): Single<List<Post>> {
        return retrofit.getPosts()
    }
}