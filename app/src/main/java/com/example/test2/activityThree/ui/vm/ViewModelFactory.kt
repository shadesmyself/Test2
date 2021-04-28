package com.example.test2.activityThree.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test2.data.datasource.ProductListRepository

class CustomViewModelFactory(private val repository: ProductListRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ActivityThreeViewModel(repository) as T
    }

}