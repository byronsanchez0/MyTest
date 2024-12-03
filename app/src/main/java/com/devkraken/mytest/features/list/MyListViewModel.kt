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

class MyListViewModel : ViewModel() {
    private lateinit var itemDao: ItemDao

    fun initDataBase(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao = MyDatabaseProvider.getDatabase(context).itemDao()
        }
    }

//    val allItems: LiveData<List<Item>> = itemDao.getAllItems()

    fun addItem(item: Item) {
        viewModelScope.launch {
            itemDao.insertItem(item)
        }
    }

    fun updateItem(item: Item) {
        viewModelScope.launch {
            itemDao.updateItem(item)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            itemDao.deleteItem(item)
        }
    }
}