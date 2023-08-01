package com.example.myapplication

import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    fun getData() = flow {
        emit(apiService.getData())
    }
}