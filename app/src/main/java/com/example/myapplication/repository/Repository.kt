package com.example.myapplication.repository

import com.example.myapplication.network.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    fun getData() = flow {
        emit(apiService.getData())
    }
}