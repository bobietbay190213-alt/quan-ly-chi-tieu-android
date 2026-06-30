package com.apkforge.quanlychitieu2appqua.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.apkforge.quanlychitieu2appqua.data.AppDatabase
import com.apkforge.quanlychitieu2appqua.data.Item
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).itemDao()

    val items = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addItem(title: String, description: String = "") {
        viewModelScope.launch {
            dao.insert(Item(title = title, description = description))
        }
    }

    fun toggleItem(item: Item) {
        viewModelScope.launch {
            dao.update(item.copy(isCompleted = !item.isCompleted))
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            dao.delete(item)
        }
    }
}
