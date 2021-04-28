package com.example.test2.data.datasource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.test2.data.datasource.ProductItemEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ProductItemEntity(
    @PrimaryKey(autoGenerate = true) var _id: Int = 0,

    @ColumnInfo(name = "image_description")
    val imageDescription: String,

    @ColumnInfo(name = "image_url")
    val image: String
)
{
    companion object {
        const val TABLE_NAME = "product_list_item_table"
    }

}
