package com.example.test2.data.datasource

import com.example.test2.data.dto.ProductItem


interface ProductDataLocalDataSource {
    suspend fun getProductItems(): List<ProductItem>
    suspend fun insertProductItem(image: String, imageDescription: String)
}