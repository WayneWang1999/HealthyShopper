package com.example.healthyshopper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.healthyshopper.model.GroceryItem
import com.example.healthyshopper.model.GroceryItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryItemViewModel @Inject constructor(
    private val repository: GroceryItemRepository
) : ViewModel() {

    val allGroceryItems: LiveData<List<GroceryItem>> = repository.allGroceryItems.asLiveData()

    fun insert(groceryItem: GroceryItem) = viewModelScope.launch {
        repository.insert(groceryItem)
    }

    // Add other ViewModel functions for update and delete as needed
}
//DIIIII no need to viewModelFactory
//class GroceryItemViewModelFactory(private val repository: GroceryItemRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(GroceryItemViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return GroceryItemViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
