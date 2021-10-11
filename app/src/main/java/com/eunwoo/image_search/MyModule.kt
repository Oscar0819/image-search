package com.eunwoo.image_search

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

var modelPart = module {
    factory<MainViewModel.DataModel> {
        MainViewModel.DataModelImpl()
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}