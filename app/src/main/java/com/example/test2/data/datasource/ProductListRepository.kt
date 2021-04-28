package com.example.test2.data.datasource

import com.example.test2.data.dto.ProductItem

class ProductListRepository(private val productDataLocalDataSource: ProductDataLocalDataSource) {

    suspend fun getAllItems(): List<ProductItem> = productDataLocalDataSource.getProductItems()
    suspend fun insertProductItem(productItem: ProductItem)  {
        productDataLocalDataSource.insertProductItem(imageDescription = productItem.text, image = productItem.image)
    }
}