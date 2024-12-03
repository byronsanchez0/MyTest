package com.devkraken.mytest.features.add

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devkraken.mytest.MyDatabaseProvider
import com.devkraken.mytest.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(private val application: Application) : ViewModel() {
    private val itemDao = MyDatabaseProvider.getDatabase(application).itemDao()

    fun addItem(title: String, description: String) {
        val item = Item(title = title, description = description)
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.insertItem(item)

        }
    }
}