package com.example.healthyshopper.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GroceryItemRepository @Inject constructor(private val groceryItemDao: GroceryItemDao) {

    val allGroceryItems: Flow<List<GroceryItem>> = groceryItemDao.getAllGroceryItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(groceryItem: GroceryItem) {
        groceryItemDao.insert(groceryItem)
    }
}