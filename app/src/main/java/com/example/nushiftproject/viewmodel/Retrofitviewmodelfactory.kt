package com.example.nushiftproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nushiftproject.model.repository.Retrofitrepository

class Retrofitviewmodelfactory(private val retrofitrepository: Retrofitrepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         return if (modelClass.isAssignableFrom(Retrofitviewmodel::class.java)) {
            Retrofitviewmodel(this.retrofitrepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}