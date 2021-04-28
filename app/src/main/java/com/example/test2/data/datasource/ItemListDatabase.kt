package com.example.test2.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductItemEntity::class], version = 1, exportSchema = true)
abstract class ItemListDatabase : RoomDatabase() {
    abstract fun productListDao(): ProductListDao

    companion object{
        private var INSTANCE: ItemListDatabase? = null

        fun getDatabase(context: Context): ItemListDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemListDatabase::class.java,
                    ProductItemEntity.TABLE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}



