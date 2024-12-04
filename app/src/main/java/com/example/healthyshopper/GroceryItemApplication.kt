package com.example.healthyshopper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GroceryItemApplication : Application()
//DIIIII, no need to create database and repository in the Application.
//{
////    val database by lazy { GroceryItemDatabase.getDatabase(this) }
////    val repository by lazy { GroceryItemRepository(database.groceryItemDao()) }
//}