package com.example.blackmouth.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackmouth.data.RetrofitClient
import com.example.blackmouth.data.services.MenuService
import com.example.blackmouth.domain.models.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    private val _menuItems = MutableStateFlow<List<MenuItem>>(emptyList())
    val menuItems = _menuItems

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage

    fun loadMenu() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitClient.createMenuService().getMenuItems()
                _menuItems.value = response
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
            _isLoading.value = false
        }
    }
}
