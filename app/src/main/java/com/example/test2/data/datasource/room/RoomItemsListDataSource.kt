package com.example.test2.data.datasource.room

import com.example.test2.data.datasource.ItemListDatabase
import com.example.test2.data.datasource.ProductDataLocalDataSource
import com.example.test2.data.datasource.ProductItemEntity
import com.example.test2.data.dto.ProductItem

class RoomItemsListDataSource(private val database: ItemListDatabase): ProductDataLocalDataSource {

    override suspend fun getProductItems(): List<ProductItem> = database.productListDao().loadAllItems().map {
        productItemEntity -> ProductItem(productItemEntity.image, productItemEntity.imageDescription)
    }

    override suspend fun insertProductItem(image: String, imageDescription: String) =
        database.productListDao().insert(productItem = ProductItemEntity(image = image, imageDescription = imageDescription))

}