package com.bugratoklu.retrofit.data

import com.bugratoklu.retrofit.Model.Post
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("/posts")
    fun getPosts():Single<List<Post>>
}