package com.example.healthyshopper.di

import android.content.Context
import androidx.room.Room
import com.example.healthyshopper.model.GroceryItemDao
import com.example.healthyshopper.model.GroceryItemDatabase
import com.example.healthyshopper.model.GroceryItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//DIIIIII  This model add for the DI
@Module
@InstallIn(SingletonComponent::class) // Correct component
object GroceryItemModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): GroceryItemDatabase {
        return Room.databaseBuilder(
            context,
            GroceryItemDatabase::class.java,
            "grocery_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideGroceryDao(database: GroceryItemDatabase): GroceryItemDao {
        return database.groceryItemDao()
    }

    @Singleton
    @Provides
    fun provideGroceryRepository(dao: GroceryItemDao): GroceryItemRepository {
        return GroceryItemRepository(dao)
    }
}