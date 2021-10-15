package com.eunwoo.image_search

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseKotlinViewModel : ViewModel() {

    private val snackbarMessage = SnackbarMessage()
    private val snackbarMessageString = SnackbarMessageString()

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun showSnackbar(stringResourceId: Int) {
        snackbarMessage.value = stringResourceId
    }

    fun showSnackbar(str: String) {
        snackbarMessageString.value = str
    }

    fun observeSnackbarMessage(lifecycleOwner: LifecycleOwner, ob: (Int) -> Unit) {
        snackbarMessage.observe(lifecycleOwner, ob)
    }
    fun observeSnackbarMessageStr(lifecycleOwner: LifecycleOwner, ob: (String) -> Unit) {
        snackbarMessageString.observe(lifecycleOwner, ob)
    }
}