package com.example.blackmouth.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackmouth.data.RetrofitClient
import com.example.blackmouth.domain.models.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    private val _menuItems = MutableStateFlow<List<MenuItem>>(emptyList())
    val menuItems = _menuItems

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage

    // ⚡ NUEVOS ESTADOS PARA EL SHOWSHEET
    private val _selectedItem = MutableStateFlow<MenuItem?>(null)
    val selectedItem: StateFlow<MenuItem?> = _selectedItem

    private val _showSheet = MutableStateFlow(false)
    val showSheet: StateFlow<Boolean> = _showSheet

    fun selectItem(item: MenuItem) {
        _selectedItem.value = item
        _showSheet.value = true
    }

    fun closeSheet() {
        _showSheet.value = false
        _selectedItem.value = null
    }


    fun loadMenu() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitClient.createMenuService().getMenuItems()
                _menuItems.value = response
                Log.d("API_CALL", "Menú cargado. Cantidad: ${response.size}")
            } catch (e: Exception) {
                Log.e("API_CALL", "Error al cargar el menú", e)
                _errorMessage.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
