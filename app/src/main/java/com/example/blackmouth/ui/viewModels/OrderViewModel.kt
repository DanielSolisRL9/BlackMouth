package com.example.blackmouth.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackmouth.data.RetrofitClient
import com.example.blackmouth.data.services.OrderService
import com.example.blackmouth.domain.dtos.CreateOrderDTO
import com.example.blackmouth.domain.dtos.OrderItemDTO
import com.example.blackmouth.domain.models.Order
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    private val service = RetrofitClient.createOrderService()

    var orders = MutableLiveData<List<Order>>()
    var loading = MutableLiveData<Boolean>()
    var error = MutableLiveData<String?>()

    fun getOrdersByUser(userId: String) {
        viewModelScope.launch {
            try {
                loading.value = true
                val result = service.getOrdersByUser(userId)
                orders.value = result
            } catch (e: Exception) {
                error.value = e.message
            } finally {
                loading.value = false
            }
        }
    }

    fun createOrder(dto: CreateOrderDTO) {
        viewModelScope.launch {
            try {
                loading.value = true
                val order = service.createOrder(dto)
                // opcional: actualizar lista
            } catch (e: Exception) {
                error.value = e.message
            } finally {
                loading.value = false
            }
        }
    }
}