package com.example.healthyshopper.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GroceryItem::class], version = 1, exportSchema = false)
abstract class GroceryItemDatabase : RoomDatabase() {

    abstract fun groceryItemDao(): GroceryItemDao
//DIIIIII   no need the object about the database
//    companion
//    object {
//        @Volatile
//        private var INSTANCE: GroceryItemDatabase? = null
//
//        fun getDatabase(context: Context): GroceryItemDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    GroceryItemDatabase::class.java,
//                    "grocery_item_database"
//
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}