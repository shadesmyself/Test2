package com.example.test2.activityThree.ui.vm

import androidx.lifecycle.MutableLiveData
import com.example.test2.BaseViewModel
import com.example.test2.data.datasource.ProductListRepository
import com.example.test2.data.dto.ProductItem

class ActivityThreeViewModel(private val repository: ProductListRepository) : BaseViewModel() {
    val items = MutableLiveData<List<ProductItem>>()

    init {
        loadRepository()
    }

    private fun loadRepository() {

        runOperation {
            work {
                items.postValue(repository.getAllItems())
            }
        }
    }

    fun createItem(imageURL: String, itemDescription: String) {

        runOperation {
            work {
                val productItem = ProductItem(imageURL, itemDescription)
                repository.insertProductItem(productItem)
                val oldItems = items.value?.toMutableList() ?: mutableListOf()
                oldItems.add(productItem)
                items.postValue(oldItems)
                items.postValue(repository.getAllItems())
            }
        }
    }
}