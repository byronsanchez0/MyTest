package com.devkraken.mytest.features.update

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devkraken.mytest.Item
import com.devkraken.mytest.MyDatabaseProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateViewModel(context: Context) : ViewModel() {
    private val itemDao = MyDatabaseProvider.getDatabase(context).itemDao()

    fun updateItem(updatedItem: Item) {
        viewModelScope.launch(Dispatchers.IO){
            itemDao.updateItem(updatedItem)
        }
    }
}