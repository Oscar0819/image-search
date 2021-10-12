package com.eunwoo.image_search

import io.reactivex.Single

interface DataModel {
    fun getData(query: String, sort: KakaoSearchSortEnum, page: Int, size: Int): Single<ImageSearchResponse>
}