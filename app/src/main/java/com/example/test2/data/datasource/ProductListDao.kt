package com.example.test2.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductListDao {

    @Query ("SELECT * FROM ${ProductItemEntity.TABLE_NAME}")

    suspend fun loadAllItems(): List<ProductItemEntity>

    @Insert(entity = ProductItemEntity::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(productItem: ProductItemEntity)
}