package com.devkraken.mytest.features.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devkraken.mytest.Item
import com.devkraken.mytest.ItemDao
import com.devkraken.mytest.MyDatabaseProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyListViewModel(private val context: Context) : ViewModel() {
    val itemDao = MyDatabaseProvider.getDatabase(context).itemDao()

    val allItems: LiveData<List<Item>> = itemDao.getAllItems()

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            itemDao.deleteItem(item)
        }
    }
}