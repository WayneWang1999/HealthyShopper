package com.example.healthyshopper

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthyshopper.adapter.GroceryItemAdapter
import com.example.healthyshopper.databinding.ActivityMainBinding
import com.example.healthyshopper.model.GroceryItem
import com.example.healthyshopper.viewmodel.GroceryItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: GroceryItemAdapter

    private val groceryItemViewModel: GroceryItemViewModel by viewModels()

//DIIIII  viewModel no need the Factory to initial
//    private val groceryItemViewModel: GroceryItemViewModel by viewModels {
//        GroceryItemViewModelFactory((application as GroceryItemApplication).repository)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Initialize RecyclerView
        binding.rvItemList.layoutManager = LinearLayoutManager(this)
        //DIIIIIII for DI, change the adapter initial with emptyList
        adapter = GroceryItemAdapter(emptyList())
        binding.rvItemList.adapter=adapter

        //DIIII change the viewModel.observer to updateData fun, need to add this function in the adapter.
        groceryItemViewModel.allGroceryItems.observe(this) { items ->
            adapter.updateData(items)
//            adapter = GroceryItemAdapter(items)
//            binding.rvItemList.adapter = adapter
        }

        // Set click listener        for the Add button
        binding.btnAddItem.setOnClickListener {
            val itemName = binding.etGroceryItem.text.toString()
            if (itemName.isNotBlank()) {
                lifecycleScope.launch {
                    groceryItemViewModel.insert(GroceryItem(itemName = itemName))
                    binding.etGroceryItem.text.clear()
                }
            }
        }
    }
}
