package com.eunwoo.image_search

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoSearchService {
    @GET("/v2/search/image")
    fun searchImage (
        @Query ("query") query: String,
        @Query ("sort") sort: String,
        @Query ("page") page: Int,
        @Query ("size") size: Int
    ): Single<ImageSearchResponse>
}