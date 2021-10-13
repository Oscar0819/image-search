package com.eunwoo.image_search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model: DataModel): BaseKotlinViewModel() {

    private val TAG = "MainViewModel"

    private val _imageSearchResponseLiveData = MutableLiveData<ImageSearchResponse>()
    val imageSearchResponseLiveData: LiveData<ImageSearchResponse>
        get() = _imageSearchResponseLiveData

    fun getImageSearch(query: String, page: Int, size:Int) {
        addDisposable(model.getData(query, KakaoSearchSortEnum.Accuracy, page, size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if (documents.size > 0) {
                        _imageSearchResponseLiveData.postValue(this)
                    }
                }
            }, {
                    Log.d(TAG, "response error, message : ${it.message}")
            }))
    }
}