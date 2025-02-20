package com.jagteshwar.epistulae.api

import com.jagteshwar.epistulae.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

    @GET("/v3/b/67b63646e41b4d34e49464ba?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    @GET("/v3/b/67b63646e41b4d34e49464ba?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories():Response<List<String>>

}