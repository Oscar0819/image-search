package com.eunwoo.image_search

class MainViewModel(private val model: DataModel): BaseKotlinViewModel() {
    interface DataModel {
        fun getData()
    }
    class DataModelImpl: DataModel{
        override fun getData() {
            return
        }
    }
}