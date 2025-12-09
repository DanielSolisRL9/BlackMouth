package com.example.blackmouth.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackmouth.data.services.MenuService
import com.example.blackmouth.domain.models.MenuItem
import kotlinx.coroutines.launch

class MenuViewModel(
    private val menuService: MenuService
) : ViewModel() {

    val menuItems = MutableLiveData<List<MenuItem>>()
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String?>()

    fun loadMenu() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val result = menuService.getMenuItems()
                menuItems.value = result
                errorMessage.value = null
            } catch (e: Exception) {
                errorMessage.value = "Error al cargar los items: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}
